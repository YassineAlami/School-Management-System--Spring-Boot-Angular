import {Component, OnInit} from '@angular/core';
import {Matiere} from "../matiere";
import {ActivatedRoute} from "@angular/router";
import {MatiereService} from "../matiere.service";

@Component({
  selector: 'app-matiere-details',
  templateUrl: './matiere-details.component.html',
  styleUrls: ['./matiere-details.component.css']
})
export class MatiereDetailsComponent implements OnInit{

  id: number = 0;
  matiere: Matiere = new Matiere();

  constructor(private route: ActivatedRoute, private matiereService: MatiereService) {
  }

  ngOnInit():void {
    this.id=this.route.snapshot.params['id'];

    this.matiere = new Matiere();
    this.matiereService.getMatiereById(this.id).subscribe(data => {
      this.matiere= data;
    });
  }

}
