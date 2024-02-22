import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Etudiant} from "src/app/etudiant";

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

  private baseURL = "http://localhost:8080/api/etudiants";

  constructor(private httpClient: HttpClient) { }

  getEtudiantsList(): Observable<Etudiant[]>{
    return this.httpClient.get<Etudiant[]>(`${this.baseURL}`);
  }

  createEtudiant (etudiant : Etudiant):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,etudiant)
  }

  getEtudiantById(id: number): Observable<Etudiant>{
    return this.httpClient.get<Etudiant>(`${this.baseURL}/${id}`);
  }

  updateEtudiant (id: number, etudiant : Etudiant):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,etudiant)
  }

  deleteEtudiant (id: number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }

}
