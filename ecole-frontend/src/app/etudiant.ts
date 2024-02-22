import {Classe} from "./classe";

export class Etudiant {
  id: number = 0;
  nom: string = '';
  prenom: string = '';
  genre: string = '';
  dateNaissance!: Date; //the '!' means that 'dateNaissance' will be assigned a value before it's accessed, even if it's not initialized in the constructor.
  adresse: string = '';
  email: string = '';
  classe: Classe = new Classe();
//  notes: Note[];
//  absences: Absence[];


  constructor() {
  }

/*  constructor(
    id: number,
    nom: string,
    prenom: string,
    genre: string,
    dateNaissance: Date,
    adresse: string,
    email: string,
//    notes: Note[],
//    absences: Absence[],
//    classe: Classe
  ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.genre = genre;
    this.dateNaissance = dateNaissance;
    this.adresse = adresse;
    this.email = email;
//    this.notes = notes;
//    this.absences = absences;
//    this.classe = classe;
  }*/
}
