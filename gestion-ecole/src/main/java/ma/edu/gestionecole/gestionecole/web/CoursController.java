package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Cours;
import ma.edu.gestionecole.gestionecole.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    // OK
    @GetMapping
    public ResponseEntity<List<Cours>> obtenirTousLesCours() {
        List<Cours> cours = coursService.obtenirTousLesCours();
        return ResponseEntity.ok(cours);
    }

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Cours> obtenirCours(@PathVariable Long id) {
        Cours cours = coursService.obtenirCours(id);
        if (cours != null) {
            return ResponseEntity.ok(cours);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping("/rechercher")
    public ResponseEntity<List<Cours>> rechercherCoursParNom(@RequestParam String nom) {
        List<Cours> cours = coursService.chercherCoursParNom(nom);
        return ResponseEntity.ok(cours);
    }

    // OK
    @PostMapping
    public ResponseEntity<Cours> ajouterCours(@Valid @RequestBody Cours cours) {
        Cours nouveauCours = coursService.ajouterCours(cours);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauCours);
    }

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Cours> mettreAJourCours(@PathVariable Long id, @Valid @RequestBody Cours cours) {
        if (!cours.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Cours coursMiseAJour = coursService.mettreAJourCours(cours);
        if (coursMiseAJour != null) {
            return ResponseEntity.ok(coursMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCours(@PathVariable Long id) {
        coursService.supprimerCours(id);
        return ResponseEntity.noContent().build();
    }
}