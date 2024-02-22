package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Classe;
import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService
{
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant obtenirEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> chercherEtudiantsParNom(String nom) {
        return etudiantRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public List<Etudiant> chercherEtudiantsParClasse(Classe classe) {
        return etudiantRepository.findByClasse(classe);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant mettreAJourEtudiant(Etudiant etudiant) {
        if (etudiantRepository.existsById(etudiant.getId())) {
            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    @Override
    public boolean existeEtudiant(Long id) {
        return etudiantRepository.existsById(id);
    }

}
