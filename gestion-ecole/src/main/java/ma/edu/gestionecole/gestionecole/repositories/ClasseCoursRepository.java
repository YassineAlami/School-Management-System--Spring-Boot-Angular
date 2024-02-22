package ma.edu.gestionecole.gestionecole.repositories;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Cours;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseCoursRepository {
    void ajouterClasseAuCours(Classe classe, Cours cours);
    void retirerClasseDuCours(Classe classe, Cours cours);
    List<Cours> obtenirCoursParClasse(Classe classe);
    List<Classe> obtenirClassesParCours(Cours cours);
}

