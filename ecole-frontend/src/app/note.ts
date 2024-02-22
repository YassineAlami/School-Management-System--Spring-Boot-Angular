import { Etudiant } from 'src/app/etudiant';
import { Matiere } from 'src/app/matiere';

export class Note {
  id: number = 0;
  valeur: number = 0;
  etudiant: Etudiant = new Etudiant();
  matiere: Matiere = new Matiere();
  noteDate!: Date;

  constructor(){}
/*  constructor(id: number, valeur: number, etudiant: Etudiant, matiere: Matiere) {
    this.id = id;
    this.valeur = valeur;
//    this.etudiant = etudiant;
    this.matiere = matiere;
  }*/
}
