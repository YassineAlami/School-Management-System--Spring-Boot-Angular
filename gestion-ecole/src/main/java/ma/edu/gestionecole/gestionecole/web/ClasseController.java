package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {
    private final ClasseService classeService;

    @Autowired
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    // OK
    @PostMapping
    public ResponseEntity<Classe> ajouterClasse(@Valid @RequestBody Classe classe) {
        Classe nouvelleClasse = classeService.ajouterClasse(classe);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleClasse);
    }

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Classe> obtenirClasse(@PathVariable Long id) {
        Classe classe = classeService.obtenirClasse(id);
        if (classe != null) {
            return ResponseEntity.ok(classe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping
    public List<Classe> obtenirToutesLesClasses() {
        return classeService.obtenirToutesLesClasses();
    }

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Classe> mettreAJourClasse(@PathVariable Long id, @Valid @RequestBody Classe classe) {
        if (!classe.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Classe classeMiseAJour = classeService.mettreAJourClasse(classe);
        if (classeMiseAJour != null) {
            return ResponseEntity.ok(classeMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClasse(@PathVariable Long id) {
        if (classeService.existeClasse(id)) {
            classeService.supprimerClasse(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}