package ma.edu.gestionecole.gestionecole.repositories;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long>
{
}
