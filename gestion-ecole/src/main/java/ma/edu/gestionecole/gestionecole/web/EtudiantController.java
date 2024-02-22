package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.*;
import ma.edu.gestionecole.gestionecole.services.AbsenceService;
import ma.edu.gestionecole.gestionecole.services.ClasseService;
import ma.edu.gestionecole.gestionecole.services.EtudiantService;
import ma.edu.gestionecole.gestionecole.services.MatiereService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;
    private final AbsenceService absenceService;
    private final MatiereService matiereService;
    private final ClasseService classeService;
    //private final NoteService noteService; // Assurez-vous d'avoir injecté le service NoteService

    @Autowired
    public EtudiantController(EtudiantService etudiantService, AbsenceService absenceService, MatiereService matiereService, ClasseService classeService /*, NoteService noteService*/) {
        this.etudiantService = etudiantService;
        this.absenceService = absenceService;
        this.matiereService = matiereService;
        this.classeService = classeService;
        //this.noteService = noteService; // Injectez le service NoteService ici
    }

    // OK
    @PostMapping
    public ResponseEntity<Etudiant> ajouterEtudiant(@Valid @RequestBody Etudiant etudiant) {
        Etudiant nouveauEtudiant = etudiantService.ajouterEtudiant(etudiant);

        // Retrieve the Classe associated with the Etudiant
        Classe classe = etudiant.getClasse();

        // Increment the capacite attribute
        classeService.incrementerCapacite(classe.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauEtudiant);
    }

    //Exemple de l'Ajout
    /* a condition qu'on a deja une classe existante avec l'Id spécifié
    {
        "nom": "test",
        "prenom": "test",
        "dateNaissance": "1994-07-31",
        "genre": "M",
        "adresse": "Fake Address 404",
        "email": "test@googel.com",
        "classe": {
            "id":1
        }
    }
    */

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> obtenirEtudiant(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.obtenirEtudiant(id);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping
    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantService.obtenirTousLesEtudiants();
    }

    // OK
    @GetMapping("/chercher")
    public List<Etudiant> chercherEtudiantsParNom(@RequestParam String nom) {
        return etudiantService.chercherEtudiantsParNom(nom);
    }
    // Exemple de la recherch par nom
    /*
       http://localhost:8080/api/etudiants/chercher?nom=y
        OR
       GET (HTTP)
       KEY -> nom
       VALUE -> ALAMI
    */

    // ??
    @GetMapping("/classe/{id}")
    public List<Etudiant> chercherEtudiantsParClasse(@PathVariable Long id) {
        Classe classe = new Classe();
        classe.setId(id);
        return etudiantService.chercherEtudiantsParClasse(classe);
    }

    // NO
    /*@PutMapping("/{id}")
    public ResponseEntity<Etudiant> mettreAJourEtudiant(@PathVariable Long id, @Valid @RequestBody Etudiant etudiant) {
        if (etudiant.getId() != null && !etudiant.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Etudiant etudiantMisAJour = etudiantService.mettreAJourEtudiant(etudiant);
        if (etudiantMisAJour != null) {
            return ResponseEntity.ok(etudiantMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> mettreAJourEtudiant(@PathVariable Long id, @Valid @RequestBody Etudiant updatedEtudiant) {
        // Check si l'etudiant existe
        if (!etudiantService.existeEtudiant(id)) {
            return ResponseEntity.notFound().build();
        }
        // recevoir l'étudiant existant
        Etudiant existingEtudiant = etudiantService.obtenirEtudiant(id);

        // Retrieve the Classe associated with the Etudiant
        Classe classe = existingEtudiant.getClasse();

        // Decrement the capacite attribute
        classeService.decrementerCapacite(classe.getId());

        // Update the attributes with the new values
        existingEtudiant.setNom(updatedEtudiant.getNom());
        existingEtudiant.setPrenom(updatedEtudiant.getPrenom());
        existingEtudiant.setGenre(updatedEtudiant.getGenre());
        existingEtudiant.setDateNaissance(updatedEtudiant.getDateNaissance());
        existingEtudiant.setAdresse(updatedEtudiant.getAdresse());
        existingEtudiant.setEmail(updatedEtudiant.getEmail());
        existingEtudiant.setClasse(updatedEtudiant.getClasse());
        // Sauvgarder l'etudiant modifié
        Etudiant updated = etudiantService.mettreAJourEtudiant(existingEtudiant);

        // Retourner l'etudiant modifié si trouvé ou un msg le cas échéant
        if (updated != null) {

            // Retrieve the Classe associated with the Etudiant
            classe = existingEtudiant.getClasse();

            // Increment the capacite attribute
            classeService.incrementerCapacite(classe.getId());

            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEtudiant(@PathVariable Long id) {

        // Retrieve the Classe associated with the Etudiant
        Classe classe = etudiantService.obtenirEtudiant(id).getClasse();

        etudiantService.supprimerEtudiant(id);

        // Decrement the capacite attribute
        classeService.decrementerCapacite(classe.getId());

        return ResponseEntity.noContent().build();
    }



    /*@PostMapping("/{etudiantId}/notes")
    public ResponseEntity<Note> ajouterNoteAEtudiant1(@PathVariable Long etudiantId, @Valid @RequestBody Note note) {
        // Vérifier si l'étudiant existe
        if (!etudiantService.existeEtudiant(etudiantId)) {
            return ResponseEntity.notFound().build();
        }

        // Obtenir l'étudiant
        Etudiant etudiant = etudiantService.obtenirEtudiant(etudiantId);

        // Associer l'étudiant à la note
        note.setEtudiant(etudiant);

        // Sauvegarder la note
        Note nouvelleNote = noteService.ajouterNote(note);

        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleNote);
    }*/

    /*
    @PostMapping("/{etudiantId}/notes")
    public ResponseEntity<Note> ajouterNoteAUnEtudiant2(@PathVariable Long etudiantId, @Valid @RequestBody Note note) {
        Etudiant etudiant = etudiantService.obtenirEtudiant(etudiantId);

        if (etudiant == null) {
            return ResponseEntity.notFound().build();
        }

        note.setEtudiant(etudiant);
        Note nouvelleNote = noteService.ajouterNote(note);

        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleNote);
    }*/


/*
    @PostMapping("/{etudiantId}/absences")
    public ResponseEntity<Absence> ajouterAbsenceAEtudiant(
            @PathVariable Long etudiantId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateAbsence,
            @RequestParam String motif,
            @RequestParam Long matiereId) {
        Etudiant etudiant = etudiantService.obtenirEtudiant(etudiantId);
        Matiere matiere = matiereService.obtenirMatiere(matiereId);

        if (etudiant == null || matiere == null) {
            return ResponseEntity.notFound().build();
        }

        Absence nouvelleAbsence = new Absence();
        nouvelleAbsence.setEtudiant(etudiant);
        nouvelleAbsence.setMatiere(matiere);
        nouvelleAbsence.setDateAbsence(dateAbsence);
        nouvelleAbsence.setMotif(motif);

        Absence absenceAjoutee = absenceService.ajouterAbsence(nouvelleAbsence);
        return ResponseEntity.ok(absenceAjoutee);
    }*/

}