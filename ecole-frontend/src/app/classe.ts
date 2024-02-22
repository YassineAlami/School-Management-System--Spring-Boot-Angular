import { Etudiant } from 'src/app/etudiant';
/*import { Cours } from './cours';
import { Enseignant } from './enseignant';*/

export class Classe {
  id: number = 0;
  nom: string = '';
  capacite: number = 0;
  anneeScolaire: number = 0;
  etudiants: Etudiant[] = [];

  /*  cours: Cours[];
  enseignantPrincipal: Enseignant;*/

  constructor() {}
}
