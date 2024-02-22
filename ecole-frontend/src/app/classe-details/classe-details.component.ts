import {Component, OnInit} from '@angular/core';
import {Matiere} from "../matiere";
import {ActivatedRoute} from "@angular/router";
import {MatiereService} from "../matiere.service";
import {Classe} from "../classe";
import {ClasseService} from "../classe.service";

@Component({
  selector: 'app-classe-details',
  templateUrl: './classe-details.component.html',
  styleUrls: ['./classe-details.component.css']
})
export class ClasseDetailsComponent implements OnInit{

  id: number = 0;
  classe: Classe = new Classe();

  constructor(private route: ActivatedRoute, private classeService: ClasseService) {
  }

  ngOnInit():void {
    this.id=this.route.snapshot.params['id'];

    this.classe = new Classe();
    this.classeService.getClasseById(this.id).subscribe(data => {
      this.classe= data;
      console.log(this.classe);
    });
  }

}
