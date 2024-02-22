package ma.edu.gestionecole.gestionecole.repositories;

import ma.edu.gestionecole.gestionecole.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long>
{
    List<Enseignant> findByNomContainingIgnoreCase (String nom);

}
