package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Etudiant;

import java.util.List;

public interface EtudiantService
{
    Etudiant ajouterEtudiant(Etudiant etudiant);
    Etudiant obtenirEtudiant(Long id);
    List<Etudiant> obtenirTousLesEtudiants();
    List<Etudiant> chercherEtudiantsParNom(String nom);
    List<Etudiant> chercherEtudiantsParClasse(Classe classe);
    void supprimerEtudiant(Long id);
    Etudiant mettreAJourEtudiant(Etudiant etudiant);
    boolean existeEtudiant(Long id);
}
