package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Cours;

import java.util.List;

public interface ClasseCoursService {
    void ajouterClasseAuCours(Long classeId, Long coursId);
    void supprimerClasseDuCours(Long classeId, Long coursId);
    List<Classe> obtenirClassesPourCours(Long coursId);
    List<Cours> obtenirCoursPourClasse(Long classeId);
}
