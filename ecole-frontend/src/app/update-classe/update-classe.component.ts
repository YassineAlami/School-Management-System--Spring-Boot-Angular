import { Component } from '@angular/core';
import {Classe} from "../classe";
import {MatiereService} from "../matiere.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ClasseService} from "../classe.service";

@Component({
  selector: 'app-update-classe',
  templateUrl: './update-classe.component.html',
  styleUrls: ['./update-classe.component.css']
})
export class UpdateClasseComponent {

  id : number = 0;

  classe: Classe = new Classe();

  constructor(private classeService : ClasseService,
              private route : ActivatedRoute,
              private router : Router) {}

  ngOnInit():void {
    this.id=this.route.snapshot.params['id'];

    this.classeService.getClasseById(this.id).subscribe(data =>{
      this.classe = data;
    },error => console.log(error));
  }

  saveClasse (){
    this.classeService.createClasse(this.classe).subscribe( data =>{
      console.log(data)
    },error => console.log(error));
  }

  onSubmit(){
    this.classeService.updateClasse(this.id, this.classe).subscribe(data =>{
      this.goToClassesList();
    },error => console.log(error));

  }

  goToClassesList(){
    this.router.navigate(['admin/classes']);
  }

}
