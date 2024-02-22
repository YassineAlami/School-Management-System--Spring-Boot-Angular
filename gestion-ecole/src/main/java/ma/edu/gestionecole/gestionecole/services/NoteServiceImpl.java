package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.entities.Note;
import ma.edu.gestionecole.gestionecole.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note ajouterNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note obtenirNote(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Note> obtenirToutesLesNotes() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> obtenirNotesParEtudiant(Etudiant etudiant) {
        return noteRepository.findByEtudiant(etudiant);
    }

    @Override
    public List<Note> obtenirNotesParMatiere(Matiere matiere) {
        return noteRepository.findByMatiere(matiere);
    }

    @Override
    public void supprimerNote(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public boolean existeNote(Long id) {
        return noteRepository.existsById(id);
    }

    @Override
    public Note mettreAJourNote(Note note) {
        if (noteRepository.existsById(note.getId())) {
            return noteRepository.save(note);
        }
        return null;
    }

    @Override
    public Note ajouterNoteSansEtudiant(double valeur) {
        Note note = new Note();
        note.setValeur(valeur);
        return noteRepository.save(note);
    }

    @Override
    public Note mettreAJourNoteSansEtudiant(Long id, double nouvelleValeur) {
        if (noteRepository.existsById(id)) {
            Note note = noteRepository.findById(id).orElse(null);
            if (note != null) {
                note.setValeur(nouvelleValeur);
                return noteRepository.save(note);
            }
        }
        return null;
    }
}
