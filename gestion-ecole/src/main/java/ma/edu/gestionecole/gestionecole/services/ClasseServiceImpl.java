package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;

    @Autowired
    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public Classe ajouterClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public Classe obtenirClasse(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Classe> obtenirToutesLesClasses() {
        return classeRepository.findAll();
    }

    @Override
    public void supprimerClasse(Long id) {
        classeRepository.deleteById(id);
    }

    @Override
    public Classe mettreAJourClasse(Classe classe) {
        if (classeRepository.existsById(classe.getId())) {
            return classeRepository.save(classe);
        }
        return null;
    }

    @Override
    public boolean existeClasse(Long id) {
        return classeRepository.existsById(id);
    }

    @Override
    public Classe incrementerCapacite(Long id) {
        Optional<Classe> optionalClasse = classeRepository.findById(id);

        if (optionalClasse.isPresent()) {
            Classe classe = optionalClasse.get();
            classe.setCapacite(classe.getCapacite() + 1);
            return classeRepository.save(classe);
        } else {
            throw new EntityNotFoundException("Classe with id " + id + " not found.");
        }
    }

    @Override
    public void decrementerCapacite(Long classeId) {
        Optional<Classe> optionalClasse = classeRepository.findById(classeId);
        if (optionalClasse.isPresent()) {
            Classe classe = optionalClasse.get();
            int capacite = classe.getCapacite();
            if (capacite > 0) {
                classe.setCapacite(capacite - 1);
                classeRepository.save(classe);
            }
        }
    }
}