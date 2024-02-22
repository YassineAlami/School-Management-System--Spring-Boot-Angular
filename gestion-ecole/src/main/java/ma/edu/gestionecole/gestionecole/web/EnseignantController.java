package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Enseignant;
import ma.edu.gestionecole.gestionecole.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    // OK
    @GetMapping
    public List<Enseignant> obtenirTousLesEnseignants() {
        return enseignantService.obtenirTousLesEnseignants();
    }

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> obtenirEnseignant(@PathVariable Long id) {
        Enseignant enseignant = enseignantService.obtenirEnseignant(id);
        if (enseignant != null) {
            return ResponseEntity.ok(enseignant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping("/chercher")
    public List<Enseignant> chercherEnseignantsParNom(@RequestParam String nom) {
        return enseignantService.chercherEnseignantsParNom(nom);
    }

    // OK
    @PostMapping
    public ResponseEntity<Enseignant> ajouterEnseignant(@Valid @RequestBody Enseignant enseignant) {
        Enseignant nouvelEnseignant = enseignantService.ajouterEnseignant(enseignant);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelEnseignant);
    }

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> mettreAJourEnseignant(@PathVariable Long id, @Valid @RequestBody Enseignant enseignant) {
        if (!enseignant.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Enseignant enseignantMisAJour = enseignantService.mettreAJourEnseignant(enseignant);
        if (enseignantMisAJour != null) {
            return ResponseEntity.ok(enseignantMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEnseignant(@PathVariable Long id) {
        enseignantService.supprimerEnseignant(id);
        return ResponseEntity.noContent().build();
    }
}