package ma.edu.gestionecole.gestionecole.web;

import ma.edu.gestionecole.gestionecole.entities.Absence;
import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {
    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<Absence> obtenirAbsence(@PathVariable Long id) {
        Absence absence = absenceService.obtenirAbsence(id);
        if (absence != null) {
            return ResponseEntity.ok(absence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @GetMapping
    public List<Absence> obtenirToutesLesAbsences() {
        return absenceService.obtenirToutesLesAbsences();
    }

    // OK
    @PostMapping
    public ResponseEntity<Absence> ajouterAbsence(@Valid @RequestBody Absence absence) {
        Absence nouvelleAbsence = absenceService.ajouterAbsence(absence);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleAbsence);
    }
    // Exemple de l'Ajout d'une Absence en précisant l'etudiant et La matière concernée
    /*
    // A condition que la matiere qui a l'Id 1 et l'etudiant avec l'Id 1 existe bien.
    {
        "dateAbsence": "2020-11-11",
        "motif": "maladie",
        "etudiant": {
            "id":1
        },
        "matiere": {
            "id":3
        }
    }
     */

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<Absence> mettreAJourAbsence(@PathVariable Long id, @Valid @RequestBody Absence absence) {
        if (!absence.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Absence absenceMiseAJour = absenceService.mettreAJourAbsence(absence);
        if (absenceMiseAJour != null) {
            return ResponseEntity.ok(absenceMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAbsence(@PathVariable Long id) {
        if (absenceService.existeAbsence(id)) {
            absenceService.supprimerAbsence(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //
    @GetMapping("/etudiant/{etudiantId}")
    public List<Absence> chercherAbsencesParEtudiant(@PathVariable Long etudiantId) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantId);
        return absenceService.chercherAbsencesParEtudiant(etudiant);
    }

    @GetMapping("/matiere/{matiereId}")
    public List<Absence> chercherAbsencesParMatiere(@PathVariable Long matiereId) {
        Matiere matiere = new Matiere();
        matiere.setId(matiereId);
        return absenceService.chercherAbsencesParMatiere(matiere);
    }
}

