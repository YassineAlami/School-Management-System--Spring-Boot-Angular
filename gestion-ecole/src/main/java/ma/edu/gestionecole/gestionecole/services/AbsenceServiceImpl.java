package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Absence;
import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;

    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public Absence ajouterAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public Absence obtenirAbsence(Long id) {
        return absenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Absence> obtenirToutesLesAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public List<Absence> chercherAbsencesParEtudiant(Etudiant etudiant) {
        return absenceRepository.findByEtudiant(etudiant);
    }

    @Override
    public List<Absence> chercherAbsencesParMatiere(Matiere matiere) {
        return absenceRepository.findByMatiere(matiere);
    }

    @Override
    public void supprimerAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public Absence mettreAJourAbsence(Absence absence) {
        if (absenceRepository.existsById(absence.getId())) {
            return absenceRepository.save(absence);
        }
        return null;
    }

    @Override
    public boolean existeAbsence(Long id) {
        return absenceRepository.existsById(id);
    }
}
