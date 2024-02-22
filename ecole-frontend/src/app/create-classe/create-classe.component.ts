import {Component, OnInit} from '@angular/core';
import {Classe} from "../classe";
import {MatiereService} from "../matiere.service";
import {Router} from "@angular/router";
import {ClasseService} from "../classe.service";

@Component({
  selector: 'app-create-classe',
  templateUrl: './create-classe.component.html',
  styleUrls: ['./create-classe.component.css']
})
export class CreateClasseComponent implements OnInit{

  classe: Classe = new Classe();

  constructor(private classeService : ClasseService,
              private router: Router) {}

  ngOnInit():void {
    this.classe.anneeScolaire = new Date().getFullYear();
  }

  saveClasse (){
    this.classeService.createClasse(this.classe).subscribe( data =>{
      console.log(data);
      this.goToClassesList();
    },error => console.log(error));
  }

  goToClassesList(){
    this.router.navigate(['admin/classes']);
  }

  onSubmit(){
    console.log(this.classe);
    this.saveClasse();
  }
}
