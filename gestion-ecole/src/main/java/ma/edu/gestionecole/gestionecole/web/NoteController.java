package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.entities.Note;
import ma.edu.gestionecole.gestionecole.services.EtudiantService;
import ma.edu.gestionecole.gestionecole.services.MatiereService;
import ma.edu.gestionecole.gestionecole.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // OK
    @PostMapping
    public ResponseEntity<Note> ajouterNote(@Valid @RequestBody Note note) {
        Note nouvelleNote = noteService.ajouterNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleNote);
    }
    // Exemple de l'Ajout Complet:
    /*
    {
        "valeur": 17.5,
            "etudiant": {
            "id": 1
        },
            "matiere": {
            "id": 1
        }
    }
    */


    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Note> obtenirNote(@PathVariable Long id) {
        Note note = noteService.obtenirNote(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping
    public List<Note> obtenirToutesLesNotes() {
        return noteService.obtenirToutesLesNotes();
    }

    // OK
    @GetMapping("/etudiant/{etudiantId}")
    public List<Note> obtenirNotesParEtudiant(@PathVariable Long etudiantId) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantId);
        return noteService.obtenirNotesParEtudiant(etudiant);
    }

    // OK
    @GetMapping("/matiere/{matiereId}")
    public List<Note> obtenirNotesParMatiere(@PathVariable Long matiereId) {
        Matiere matiere = new Matiere();
        matiere.setId(matiereId);
        return noteService.obtenirNotesParMatiere(matiere);
    }

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Note> mettreAJourNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        if (!noteService.existeNote(id)) {
            return ResponseEntity.notFound().build();
        }
        note.setId(id);
        Note noteMiseAJour = noteService.mettreAJourNote(note);
        if (noteMiseAJour != null) {
            return ResponseEntity.ok(noteMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Exemple de la modification avec
/*
    PUT > http://localhost:8080/api/notes/3
    // Le meme id dans l'URL et dans Json "id"
    {
        "id":3,
        "valeur": 19.75,
        "etudiant": {
            "id": 1
        },
            "matiere": {
            "id": 1
        }
    }
    // si je change les Id's de l'etudiant ou la matiere ils vont etre modifie' mais pas le contenu de Etudiants ou Matieres
*/


    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerNote(@PathVariable Long id) {
        noteService.supprimerNote(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ajouter-sans-etudiant")
    public ResponseEntity<Note> ajouterNoteSansEtudiant(@RequestParam double valeur) {
        Note note = noteService.ajouterNoteSansEtudiant(valeur);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @PutMapping("/mettre-a-jour-sans-etudiant/{id}")
    public ResponseEntity<Note> mettreAJourNoteSansEtudiant(@PathVariable Long id, @RequestParam double nouvelleValeur) {
        if (!noteService.existeNote(id)) {
            return ResponseEntity.notFound().build();
        }
        Note noteMiseAJour = noteService.mettreAJourNoteSansEtudiant(id, nouvelleValeur);
        if (noteMiseAJour != null) {
            return ResponseEntity.ok(noteMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

