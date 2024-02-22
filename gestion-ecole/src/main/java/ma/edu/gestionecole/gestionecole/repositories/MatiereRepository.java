package ma.edu.gestionecole.gestionecole.repositories;

import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long>
{
    List<Matiere> findByNomContainingIgnoreCase(String nom);
}
