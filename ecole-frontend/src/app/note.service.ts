import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Note} from "./note";
import {Etudiant} from "./etudiant";

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  private baseURL="http://localhost:8080/api/notes"

  constructor(private httpClient: HttpClient) { }

  getNotesList(): Observable<Note[]>{
    return this.httpClient.get<Note[]>(`${this.baseURL}`);
  }

  getNotesByEtudiantId(etudiantId: number): Observable<Note[]> {
    return this.httpClient.get<Note[]>(`${this.baseURL}/etudiant/${etudiantId}`);
  }

  createNote(note: Note): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,note);
  }

  getNoteById(id: number): Observable<Note>{
    return this.httpClient.get<Note>(`${this.baseURL}/${id}`);
  }

  updateNote (id: number, note : Note):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,note)
  }

  deleteNote (id: number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }

}
