import {Component, OnInit} from '@angular/core';
import {Note} from "../note";
import {NoteService} from "../note.service";
import {Router} from "@angular/router";
import { Etudiant } from 'src/app/etudiant';
import { Matiere } from 'src/app/matiere';
import {EtudiantService} from "../etudiant.service";
import {MatiereService} from "../matiere.service";
import {Classe} from "../classe";
import {ClasseService} from "../classe.service";
import {AuthenticationService} from "../authentication.service";


@Component({
  selector: 'app-create-note',
  templateUrl: './create-note.component.html',
  styleUrls: ['./create-note.component.css']
})
export class CreateNoteComponent implements OnInit{

  note : Note = new Note();
  etudiants: Etudiant[] = [];
  matieres: Matiere[] = [];
  classes: Classe[] = [];

  // Selected class and filtered students
  selectedClass: Classe = new Classe();
  filteredStudents: Etudiant[] = [];

  constructor(private  noteService: NoteService, private router: Router,
              private etudiantService: EtudiantService,
              private classeService: ClasseService,
              private matiereService: MatiereService) {
  }

  ngOnInit():void {
    this.fetchEtudiants();
    this.fetchMatieres();
    this.fetchClasses();
  }

  // Fetch Etudiant data
  fetchEtudiants() {
    this.etudiantService.getEtudiantsList().subscribe((data: Etudiant[]) => {
      this.etudiants = data;
    });
  }

  // Fetch Matiere data
  fetchMatieres() {
    this.matiereService.getMatieresList().subscribe((data: Matiere[]) => {
      this.matieres = data;
    });
  }

  // Fetch Classe data
  fetchClasses() {
    this.classeService.getClasseList().subscribe((data: Classe[]) => {
      this.classes = data;
    });
  }

  // Method to filter students based on the selected class
  onClassSelect(selectedClass: Classe) {
    this.filteredStudents = this.etudiants.filter(
      (etudiant) => etudiant.classe?.id === selectedClass.id
    );
  }

  saveNote (){
    this.noteService.createNote(this.note).subscribe( data =>{
      console.log(data);
      this.goToMatieresList();
    },error => console.log(error));
  }


  goToMatieresList(){
    this.router.navigate(['admin/notes']);
  }

  onSubmit(){
    console.log(this.note);
    this.saveNote();
  }
}
