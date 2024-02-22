package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Absence;
import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;

import java.util.List;

public interface AbsenceService {
    Absence ajouterAbsence(Absence absence);
    Absence obtenirAbsence(Long id);
    List<Absence> obtenirToutesLesAbsences();
    List<Absence> chercherAbsencesParEtudiant(Etudiant etudiant);
    List<Absence> chercherAbsencesParMatiere(Matiere matiere);
    void supprimerAbsence(Long id);
    Absence mettreAJourAbsence(Absence absence);
    boolean existeAbsence(Long id);
}