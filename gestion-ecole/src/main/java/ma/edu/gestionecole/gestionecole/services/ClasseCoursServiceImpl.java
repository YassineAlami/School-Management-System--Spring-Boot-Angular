package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Cours;
import ma.edu.gestionecole.gestionecole.repositories.ClasseRepository;
import ma.edu.gestionecole.gestionecole.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClasseCoursServiceImpl implements ClasseCoursService {

    private final ClasseRepository classeRepository;
    private final CoursRepository coursRepository;

    @Autowired
    public ClasseCoursServiceImpl(ClasseRepository classeRepository, CoursRepository coursRepository) {
        this.classeRepository = classeRepository;
        this.coursRepository = coursRepository;
    }

    @Override
    public void ajouterClasseAuCours(Long classeId, Long coursId) {
        Classe classe = classeRepository.findById(classeId).orElse(null);
        Cours cours = coursRepository.findById(coursId).orElse(null);

        if (classe != null && cours != null) {
            classe.getCours().add(cours);
            classeRepository.save(classe);
        }
    }

    @Override
    public void supprimerClasseDuCours(Long classeId, Long coursId) {
        Classe classe = classeRepository.findById(classeId).orElse(null);
        Cours cours = coursRepository.findById(coursId).orElse(null);

        if (classe != null && cours != null) {
            classe.getCours().remove(cours);
            classeRepository.save(classe);
        }
    }

    @Override
    public List<Classe> obtenirClassesPourCours(Long coursId) {
        Cours cours = coursRepository.findById(coursId).orElse(null);

        if (cours != null) {
            return cours.getClasses();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Cours> obtenirCoursPourClasse(Long classeId) {
        Classe classe = classeRepository.findById(classeId).orElse(null);

        if (classe != null) {
            return classe.getCours();
        } else {
            return new ArrayList<>();
        }
    }
}