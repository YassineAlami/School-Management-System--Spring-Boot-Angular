import { Component } from '@angular/core';
import {Etudiant} from "../etudiant";
import {MatiereService} from "../matiere.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EtudiantService} from "../etudiant.service";
import {Classe} from "../classe";
import {ClasseService} from "../classe.service";

@Component({
  selector: 'app-update-etudiant',
  templateUrl: './update-etudiant.component.html',
  styleUrls: ['./update-etudiant.component.css']
})
export class UpdateEtudiantComponent {

  id : number = 0;
  etudiant: Etudiant = new Etudiant();
  classes: Classe[] = [];

  constructor(private etudiantService : EtudiantService, private classeService: ClasseService,
              private route : ActivatedRoute,
              private router : Router,) {}

  ngOnInit():void {
    this.fetchClasses();
    this.id=this.route.snapshot.params['id'];

    this.etudiantService.getEtudiantById(this.id).subscribe(data =>{
      this.etudiant = data;
    },error => console.log(error));
  }

  // Fetch Classe data
  fetchClasses() {
    this.classeService.getClasseList().subscribe((data: Classe[]) => {
      this.classes = data;
    });
  }

  saveMatiere (){
    this.etudiantService.createEtudiant(this.etudiant).subscribe( data =>{
      console.log(data)
    },error => console.log(error));
  }

  onSubmit(){
    this.etudiantService.updateEtudiant(this.id, this.etudiant).subscribe(data =>{
      this.goToEtudiantsList();
    },error => console.log(error));

  }

  goToEtudiantsList(){
    this.router.navigate(['admin/etudiants']);
  }

}
