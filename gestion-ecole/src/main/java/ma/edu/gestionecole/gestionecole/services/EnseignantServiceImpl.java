package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Enseignant;
import ma.edu.gestionecole.gestionecole.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService {
    private final EnseignantRepository enseignantRepository;

    @Autowired
    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public Enseignant ajouterEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant obtenirEnseignant(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Enseignant> obtenirTousLesEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public List<Enseignant> chercherEnseignantsParNom(String nom) {
        return enseignantRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public Enseignant mettreAJourEnseignant(Enseignant enseignant) {
        if (existeEnseignant(enseignant.getId())) {
            return enseignantRepository.save(enseignant);
        }
        return null;
    }

    @Override
    public void supprimerEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public boolean existeEnseignant(Long id) {
        return enseignantRepository.existsById(id);
    }
}
