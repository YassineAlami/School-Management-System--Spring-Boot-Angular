package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Enseignant;

import java.util.List;

public interface EnseignantService
{
    Enseignant ajouterEnseignant(Enseignant enseignant);
    Enseignant obtenirEnseignant(Long id);
    List<Enseignant> obtenirTousLesEnseignants();
    List<Enseignant> chercherEnseignantsParNom(String nom);
    Enseignant mettreAJourEnseignant(Enseignant enseignant);
    void supprimerEnseignant(Long id);
    boolean existeEnseignant(Long id);
}