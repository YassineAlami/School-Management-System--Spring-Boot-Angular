package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Matiere;

import java.util.List;

public interface MatiereService {
    Matiere ajouterMatiere(Matiere matiere);
    Matiere obtenirMatiere(Long id);

    List<Matiere> obtenirMatieresParNom(String nom);

    List<Matiere> obtenirToutesLesMatieres();
    void supprimerMatiere(Long id);
    Matiere mettreAJourMatiere(Matiere matiere);
    boolean existeMatiere(Long id);
}
