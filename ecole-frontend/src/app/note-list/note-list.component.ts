import {Component, OnInit} from '@angular/core';
import {Note} from "../note";
import {NoteService} from "../note.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../authentication.service";

@Component({
  selector: 'app-note-list',
  templateUrl: './note-list.component.html',
  styleUrls: ['./note-list.component.css']
})
export class NoteListComponent implements OnInit{

  notes: Note[] = [];

  constructor(private noteService: NoteService, private router :Router,
              public autheService : AuthenticationService) {
  }

  ngOnInit() {
    this.getNotes();
  }

  private getNotes(){
    this.noteService.getNotesList().subscribe(data=>{
      this.notes = data;
    })
  }

  noteDetails(id : number){
    //dak 'matiere-details' howa li preciserna f app-routing-module : {path:'matiere-details/:id', component: MatiereDetailsComponent},
    this.router.navigate(['admin/note-details',id]);
  }

  updateNote(id : number){
    this.router.navigate(['admin/update-note',id]);
  }
  deleteNote(id: number){
    this.noteService.deleteNote(id).subscribe(data =>{
      console.log(data)
      this.getNotes();
    })
  }
}
