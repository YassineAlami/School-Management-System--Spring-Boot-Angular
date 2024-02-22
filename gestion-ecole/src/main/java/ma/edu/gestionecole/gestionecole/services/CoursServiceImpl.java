package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Cours;
import ma.edu.gestionecole.gestionecole.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;

    @Autowired
    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public Cours ajouterCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours obtenirCours(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cours> obtenirTousLesCours() {
        return coursRepository.findAll();
    }

    @Override
    public List<Cours> chercherCoursParNom(String nom) {
        return coursRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public void supprimerCours(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public Cours mettreAJourCours(Cours cours) {
        if (coursRepository.existsById(cours.getId())) {
            return coursRepository.save(cours);
        }
        return null;
    }

    @Override
    public boolean existeCours(Long id) {
        return coursRepository.existsById(id);
    }
}