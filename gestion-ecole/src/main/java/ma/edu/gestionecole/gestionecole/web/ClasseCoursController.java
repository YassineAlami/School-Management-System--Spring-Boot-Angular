package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Cours;
import ma.edu.gestionecole.gestionecole.services.ClasseCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classe-cours")
public class ClasseCoursController {

    private final ClasseCoursService classeCoursService;

    @Autowired
    public ClasseCoursController(ClasseCoursService classeCoursService) {
        this.classeCoursService = classeCoursService;
    }

    // OK
    @PostMapping("/ajouter-classe-au-cours")
    public ResponseEntity<String> ajouterClasseAuCours(@RequestParam Long classeId, @RequestParam Long coursId) {
        classeCoursService.ajouterClasseAuCours(classeId, coursId);
        return ResponseEntity.ok("La classe a été ajoutée au cours avec succès.");
    }
    // Exemple de l'ajout:
     /*
     POST > http://localhost:8080/api/classe-cours/ajouter-classe-au-cours
     x-www-form-urlencoded >
     classeId : 1
     coursId : 1
     */

     // OK
    @PostMapping("/supprimer-classe-du-cours")
    public ResponseEntity<String> supprimerClasseDuCours(@RequestParam Long classeId, @RequestParam Long coursId) {
        classeCoursService.supprimerClasseDuCours(classeId, coursId);
        return ResponseEntity.ok("La classe a été supprimée du cours avec succès.");
    }
    // Exemple de la suppression
    /*
    POST > http://localhost:8080/api/classe-cours/supprimer-classe-du-cours?classeId=1&coursId=1
    Params > classeId :1; coursId :1
    */

    // OK
    @GetMapping("/classes-pour-cours/{coursId}")
    public ResponseEntity<List<Classe>> obtenirClassesPourCours(@PathVariable Long coursId) {
        List<Classe> classes = classeCoursService.obtenirClassesPourCours(coursId);
        return ResponseEntity.ok(classes);
    }

    // OK
    @GetMapping("/cours-pour-classe/{classeId}")
    public ResponseEntity<List<Cours>> obtenirCoursPourClasse(@PathVariable Long classeId) {
        List<Cours> cours = classeCoursService.obtenirCoursPourClasse(classeId);
        return ResponseEntity.ok(cours);
    }
}