import {Component, OnInit} from '@angular/core';
import {Etudiant} from "../etudiant";
import {ActivatedRoute} from "@angular/router";
import {MatiereService} from "../matiere.service";
import {EtudiantService} from "../etudiant.service";
import {Matiere} from "../matiere";
import {Note} from "../note";
import {NoteService} from "../note.service";

@Component({
  selector: 'app-etudiant-details',
  templateUrl: './etudiant-details.component.html',
  styleUrls: ['./etudiant-details.component.css']
})
export class EtudiantDetailsComponent implements OnInit {

  id: number = 0;
  etudiant: Etudiant = new Etudiant();

  notes: Note[] = [];

  constructor(private route: ActivatedRoute, private etudiantService: EtudiantService,
              private noteService: NoteService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.etudiant = new Etudiant();
    this.etudiantService.getEtudiantById(this.id).subscribe(data => {
      this.etudiant= data;
    });

    this.getNotesByEtudiantId(this.id);
  }

  getNotesByEtudiantId(etudiantId: number): void {
    this.noteService.getNotesByEtudiantId(etudiantId).subscribe(
      (data) => {
        this.notes = data;
      },
      (error) => {
        console.error('Error:', error);
      }
    );
  }



}
