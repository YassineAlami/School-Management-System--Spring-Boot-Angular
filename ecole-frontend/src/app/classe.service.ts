import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Matiere} from "./matiere";
import {Classe} from "./classe";

@Injectable({
  providedIn: 'root'
})
export class ClasseService {

  private baseURL = "http://localhost:8080/api/classes";

  constructor(private httpClient: HttpClient) { }

  getClasseList(): Observable<Classe[]>{
    return this.httpClient.get<Classe[]>(`${this.baseURL}`);
  }

  createClasse (classe : Classe):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,classe)
  }

  getClasseById(id: number): Observable<Classe>{
    return this.httpClient.get<Classe>(`${this.baseURL}/${id}`);
  }

  updateClasse (id: number, classe : Classe):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,classe)
  }

  deleteClasse (id: number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }
}
