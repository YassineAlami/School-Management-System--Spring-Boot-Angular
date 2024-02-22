import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Matiere} from "./matiere";

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  private baseURL = "http://localhost:8080/api/matieres";

  constructor(private httpClient: HttpClient) { }

  getMatieresList(): Observable<Matiere[]>{
    return this.httpClient.get<Matiere[]>(`${this.baseURL}`);
  }

  createMatiere (matiere : Matiere):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,matiere)
  }

  getMatiereById(id: number): Observable<Matiere>{
    return this.httpClient.get<Matiere>(`${this.baseURL}/${id}`);
  }

  updateMatiere (id: number, matiere : Matiere):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,matiere)
  }

  deleteMatiere (id: number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }
}
