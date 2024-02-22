import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MatiereListComponent} from "./matiere-list/matiere-list.component";
import {CreateMatiereComponent} from "./create-matiere/create-matiere.component";
import {UpdateMatiereComponent} from "./update-matiere/update-matiere.component";
import {MatiereDetailsComponent} from "./matiere-details/matiere-details.component";
import {NoteListComponent} from "./note-list/note-list.component";
import {NoteComponent} from "./note/note.component";
import {CreateNoteComponent} from "./create-note/create-note.component";
import {EtudiantComponent} from "./etudiant/etudiant.component";
import {EtudiantListComponent} from "./etudiant-list/etudiant-list.component";
import {CreateEtudiantComponent} from "./create-etudiant/create-etudiant.component";
import {UpdateEtudiantComponent} from "./update-etudiant/update-etudiant.component";
import {EtudiantDetailsComponent} from "./etudiant-details/etudiant-details.component";
import {UpdateNoteComponent} from "./update-note/update-note.component";
import {NoteDetailsComponent} from "./note-details/note-details.component";
import {ClasseListComponent} from "./classe-list/classe-list.component";
import {CreateClasseComponent} from "./create-classe/create-classe.component";
import {UpdateClasseComponent} from "./update-classe/update-classe.component";
import {ClasseDetailsComponent} from "./classe-details/classe-details.component";
import {LoginComponent} from "./login/login.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
/*import {authenticationGuard} from "./guards/authentication.guard";*/

import { authenticationGuard } from './guards/authentication.guard';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'', redirectTo: 'login', pathMatch: 'full'},
  {path:'', component: LoginComponent},

  {path:'admin', component: AdminTemplateComponent, canActivate: [authenticationGuard],
    children : [

      {path:'matieres', component: MatiereListComponent},
      {path:'create-matiere', component: CreateMatiereComponent},
      {path:'update-matiere/:id', component: UpdateMatiereComponent},
      {path:'matiere-details/:id', component: MatiereDetailsComponent},

      {path:'notes', component: NoteListComponent},
      {path:'notes', component: NoteComponent},
      {path:'create-note', component: CreateNoteComponent},
      {path:'update-note/:id', component: UpdateNoteComponent},
      {path:'note-details/:id', component: NoteDetailsComponent},

      {path:'etudiants', component: EtudiantListComponent},
      {path:'create-etudiant', component: CreateEtudiantComponent},
      {path:'update-etudiant/:id', component: UpdateEtudiantComponent},
      {path:'etudiant-details/:id', component: EtudiantDetailsComponent},

      {path:'classes', component: ClasseListComponent},
      {path:'create-classe', component: CreateClasseComponent},
      {path:'update-classe/:id', component: UpdateClasseComponent},
      {path:'classe-details/:id', component: ClasseDetailsComponent}

    ]},

];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
