import { Component } from '@angular/core';
import {Matiere} from "../matiere";
import {MatiereService} from "../matiere.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-matiere',
  templateUrl: './update-matiere.component.html',
  styleUrls: ['./update-matiere.component.css']
})
export class UpdateMatiereComponent {

  id : number = 0;

  matiere: Matiere = new Matiere();

  constructor(private matiereService : MatiereService,
              private route : ActivatedRoute,
              private router : Router) {}

  ngOnInit():void {
    this.id=this.route.snapshot.params['id'];

    this.matiereService.getMatiereById(this.id).subscribe(data =>{
      this.matiere = data;
      },error => console.log(error));
  }

  saveMatiere (){
    this.matiereService.createMatiere(this.matiere).subscribe( data =>{
      console.log(data)
    },error => console.log(error));
  }

  onSubmit(){
    this.matiereService.updateMatiere(this.id, this.matiere).subscribe(data =>{
      this.goToMatieresList();
    },error => console.log(error));

  }

  goToMatieresList(){
    this.router.navigate(['admin/matieres']);
  }

}
