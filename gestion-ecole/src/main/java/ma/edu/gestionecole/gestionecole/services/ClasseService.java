package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Classe;

import java.util.List;

public interface ClasseService {
    Classe ajouterClasse(Classe classe);
    Classe obtenirClasse(Long id);
    List<Classe> obtenirToutesLesClasses();
    void supprimerClasse(Long id);
    Classe mettreAJourClasse(Classe classe);
    boolean existeClasse(Long id);
    Classe incrementerCapacite(Long id);
    void decrementerCapacite(Long classeId);
}
