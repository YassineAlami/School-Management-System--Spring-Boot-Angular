import {Component, OnInit} from '@angular/core';
import {Classe} from "../classe";
import {MatiereService} from "../matiere.service";
import {Router} from "@angular/router";
import {ClasseService} from "../classe.service";
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-classe-list',
  templateUrl: './classe-list.component.html',
  styleUrls: ['./classe-list.component.css']
})
export class ClasseListComponent implements OnInit{
  classes : Classe[] = [];

  constructor(private classeService : ClasseService,public autheService : AuthenticationService,
              private router :Router) {}
  ngOnInit():void {
    this.getClasses();
  }

  private getClasses(){
    this.classeService.getClasseList().subscribe(data => {
      this.classes = data;
    });
  }

  classeDetails(id : number){
    //dak 'matiere-details' howa li preciserna f app-routing-module : {path:'matiere-details/:id', component: MatiereDetailsComponent},
    this.router.navigate(['admin/classe-details',id]);
  }

  updateClass(id : number){
    this.router.navigate(['admin/update-classe',id]);
  }

  deleteClasse(id: number){
    this.classeService.deleteClasse(id).subscribe(data =>{
      console.log(data)
      this.getClasses();
    })
  }

}
