import {Component, OnInit} from '@angular/core';
import {Etudiant} from "../etudiant";
import {EtudiantService} from "../etudiant.service";
import {Router} from "@angular/router";
import {Classe} from "../classe";
import {ClasseService} from "../classe.service";

@Component({
  selector: 'app-create-etudiant',
  templateUrl: './create-etudiant.component.html',
  styleUrls: ['./create-etudiant.component.css']
})
export class CreateEtudiantComponent implements OnInit{

  etudiant: Etudiant = new Etudiant();
  classes: Classe[] = [];

  constructor(private etudiantService : EtudiantService, private router: Router,
              private classeService: ClasseService) {
  }

  ngOnInit():void {
    this.fetchClasses();
  }
  // Fetch Classe data
  fetchClasses() {
    this.classeService.getClasseList().subscribe((data: Classe[]) => {
      this.classes = data;
    });
  }

  saveEtudiant (){
    this.etudiantService.createEtudiant(this.etudiant).subscribe( data =>{
      console.log(data);
      this.goToEtudiantList();
    },error => console.log(error));
  }

  goToEtudiantList(){
    this.router.navigate(['admin/etudiants']);
  }

  onSubmit(){
    console.log(this.etudiant);
    this.saveEtudiant();
  }
}
