package ma.edu.gestionecole.gestionecole.services;

import ma.edu.gestionecole.gestionecole.entities.Etudiant;
import ma.edu.gestionecole.gestionecole.entities.Matiere;
import ma.edu.gestionecole.gestionecole.entities.Note;

import java.util.List;

public interface NoteService {
    Note ajouterNote(Note note);
    Note obtenirNote(Long id);
    List<Note> obtenirToutesLesNotes();
    List<Note> obtenirNotesParEtudiant(Etudiant etudiant);
    List<Note> obtenirNotesParMatiere(Matiere matiere);
    void supprimerNote(Long id);
    boolean existeNote(Long id);
    Note mettreAJourNote(Note note);
    Note ajouterNoteSansEtudiant(double valeur);
    Note mettreAJourNoteSansEtudiant(Long id, double nouvelleValeur);
}
