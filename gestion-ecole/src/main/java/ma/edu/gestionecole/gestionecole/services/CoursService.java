package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Cours;

import java.util.List;

public interface CoursService {
    Cours ajouterCours(Cours cours);
    Cours obtenirCours(Long id);
    List<Cours> obtenirTousLesCours();
    List<Cours> chercherCoursParNom(String nom);
    void supprimerCours(Long id);
    Cours mettreAJourCours(Cours cours);
    boolean existeCours(Long id);
}
