import { Component, OnInit } from '@angular/core';
import {Matiere} from "../matiere";
import {MatiereService} from "../matiere.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-matiere-list',
  templateUrl: './matiere-list.component.html',
  styleUrls: ['./matiere-list.component.css']
})

export class MatiereListComponent implements OnInit{

  matieres: Matiere[] = [];

  constructor(private matiereService : MatiereService, public autheService : AuthenticationService,
              private router :Router) {}

  ngOnInit():void {
    this.getMatieres();
  }

  private getMatieres(){
    this.matiereService.getMatieresList().subscribe(data => {
      this.matieres = data;
    });
  }

  matiereDetails(id : number){
    //dak 'matiere-details' howa li preciserna f app-routing-module : {path:'matiere-details/:id', component: MatiereDetailsComponent},
    this.router.navigate(['admin/matiere-details',id]);
  }


  updatematiere(id : number){
    this.router.navigate(['admin/update-matiere',id]);
  }
  deletematiere(id: number){
    this.matiereService.deleteMatiere(id).subscribe(data =>{
      console.log(data)
      this.getMatieres();
    })
  }
}
