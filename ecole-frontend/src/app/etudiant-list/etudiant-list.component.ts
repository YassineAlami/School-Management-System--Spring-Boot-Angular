import {Component, OnInit} from '@angular/core';
import {Etudiant} from "../etudiant";
import {EtudiantService} from "../etudiant.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-etudiant-list',
  templateUrl: './etudiant-list.component.html',
  styleUrls: ['./etudiant-list.component.css']
})
export class EtudiantListComponent implements OnInit{

  etudiants : Etudiant[] = [];

  constructor(private etudianService : EtudiantService, private router :Router,
              public autheService : AuthenticationService) {
  }
  ngOnInit() {
    this.getEtudiant();
  }

  private getEtudiant(){
    this.etudianService.getEtudiantsList().subscribe(data=>{
      this.etudiants=data;
    })
  }

  etudiantDetails(id : number){
    //dak 'matiere-details' howa li preciserna f app-routing-module : {path:'matiere-details/:id', component: MatiereDetailsComponent},
    this.router.navigate(['admin/etudiant-details',id]);
  }

  updateEtudiant(id : number){
    this.router.navigate(['admin/update-etudiant',id]);
  }
  deleteEtudiant(id: number){
    this.etudianService.deleteEtudiant(id).subscribe(data =>{
      console.log(data)
      this.getEtudiant();
    })
  }



}
