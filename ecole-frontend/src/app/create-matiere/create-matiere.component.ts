import {Component, OnInit} from '@angular/core';
import {Matiere} from "../matiere";
import {MatiereService} from "../matiere.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-matiere',
  templateUrl: './create-matiere.component.html',
  styleUrls: ['./create-matiere.component.css']
})

export class CreateMatiereComponent implements OnInit{

  matiere: Matiere = new Matiere();
  constructor(private matiereService : MatiereService,
              private router: Router) {}

  ngOnInit():void {

  }

  saveMatiere (){
    this.matiereService.createMatiere(this.matiere).subscribe( data =>{
      console.log(data);
      this.goToMatieresList();
    },error => console.log(error));
  }

  goToMatieresList(){
    this.router.navigate(['admin/matieres']);
  }

  onSubmit(){
    console.log(this.matiere);
    this.saveMatiere();
  }

}
