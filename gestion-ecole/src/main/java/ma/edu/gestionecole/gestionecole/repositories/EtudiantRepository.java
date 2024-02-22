package ma.edu.gestionecole.gestionecole.repositories;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>
{
    List<Etudiant> findByNomContainingIgnoreCase(String nom);
    List<Etudiant> findByClasse(Classe classe);
}
