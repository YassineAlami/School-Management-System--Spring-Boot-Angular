import {Component, OnInit} from '@angular/core';
import {Note} from "../note";
import {ActivatedRoute, Router} from "@angular/router";
import {NoteService} from "../note.service";
import { Etudiant } from 'src/app/etudiant';
import { Matiere } from 'src/app/matiere';
import {EtudiantService} from "../etudiant.service";
import {MatiereService} from "../matiere.service";
import {Classe} from "../classe";
import {ClasseService} from "../classe.service";

@Component({
  selector: 'app-update-note',
  templateUrl: './update-note.component.html',
  styleUrls: ['./update-note.component.css']
})
export class UpdateNoteComponent implements OnInit{

  id : number = 0;
  note : Note = new Note();
  etudiants: Etudiant[] = [];
  matieres: Matiere[] = [];
  classes: Classe[] = [];

  // Selected class and filtered students
  selectedClass: Classe = new Classe();
  filteredStudents: Etudiant[] = [];

  constructor(private noteService : NoteService, private classeService: ClasseService,
              private etudiantService: EtudiantService,
              private matiereService: MatiereService,
              private route : ActivatedRoute,
              private router : Router) {}

  ngOnInit():void {
    this.id=this.route.snapshot.params['id'];

    this.noteService.getNoteById(this.id).subscribe(data =>{
      this.note = data;
    },error => console.log(error));

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

  saveMatiere (){
    this.noteService.createNote(this.note).subscribe( data =>{
      console.log(data)
    },error => console.log(error));
  }

  onSubmit(){
    this.noteService.updateNote(this.id, this.note).subscribe(data =>{
      this.goToMatieresList();
    },error => console.log(error));

  }

  goToMatieresList(){
    this.router.navigate(['/notes']);
  }


}
