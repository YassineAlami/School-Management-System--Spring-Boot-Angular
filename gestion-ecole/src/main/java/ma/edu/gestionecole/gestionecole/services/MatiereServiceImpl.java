package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereServiceImpl implements MatiereService {
    private final MatiereRepository matiereRepository;

    @Autowired
    public MatiereServiceImpl(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @Override
    public Matiere ajouterMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere obtenirMatiere(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }

    @Override
    public List<Matiere> obtenirMatieresParNom(String nom) {
        return matiereRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public List<Matiere> obtenirToutesLesMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public void supprimerMatiere(Long id) {
        matiereRepository.deleteById(id);
    }

    @Override
    public Matiere mettreAJourMatiere(Matiere matiere) {
        if (matiereRepository.existsById(matiere.getId())) {
            return matiereRepository.save(matiere);
        }
        return null;
    }

    @Override
    public boolean existeMatiere(Long id) {
        return matiereRepository.existsById(id);
    }
}
