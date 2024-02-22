package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/matieres")
public class MatiereController {
    private final MatiereService matiereService;

    @Autowired
    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    // OK
    @PostMapping
    public ResponseEntity<Matiere> ajouterMatiere(@Valid @RequestBody Matiere matiere) {
        Matiere nouvelleMatiere = matiereService.ajouterMatiere(matiere);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleMatiere);
    }

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Matiere> obtenirMatiere(@PathVariable Long id) {
        Matiere matiere = matiereService.obtenirMatiere(id);
        if (matiere != null) {
            return ResponseEntity.ok(matiere);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping
    public ResponseEntity<List<Matiere>> obtenirToutesLesMatieres() {
        List<Matiere> matieres = matiereService.obtenirToutesLesMatieres();
        return ResponseEntity.ok(matieres);
    }

    // OK
    @GetMapping("/chercher")
    public ResponseEntity<List<Matiere>> chercherMatieresParNom(@RequestParam String nom) {
        List<Matiere> matieres = matiereService.obtenirMatieresParNom(nom);

        if (matieres.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(matieres);
        }
    }
    // Exemple de la recherche des Matieres par nom
    // GET >http://localhost:8080/api/matieres/chercher?nom=Java

    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMatiere(@PathVariable Long id) {
        if (matiereService.existeMatiere(id)) {
            matiereService.supprimerMatiere(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Matiere> mettreAJourMatiere(@PathVariable Long id, @Valid @RequestBody Matiere matiere) {
        if (!matiere.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Matiere matiereMiseAJour = matiereService.mettreAJourMatiere(matiere);
        if (matiereMiseAJour != null) {
            return ResponseEntity.ok(matiereMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Exemple de Modiffication
    /*
        //dans le Body, il faut egalement preciser l'Id de la Matiere a mise à jour
        PUT > http://localhost:8080/api/matieres/4
        {
            "id" : 4,
            "nom": "JAVA 3"
        }
    */
}