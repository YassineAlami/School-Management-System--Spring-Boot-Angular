import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';;

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatiereListComponent } from './matiere-list/matiere-list.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CreateMatiereComponent } from './create-matiere/create-matiere.component';
import { UpdateMatiereComponent } from './update-matiere/update-matiere.component';
import { MatiereDetailsComponent } from './matiere-details/matiere-details.component';
import { NoteListComponent } from './note-list/note-list.component';
import { NoteComponent } from './note/note.component';
import { CreateNoteComponent } from './create-note/create-note.component';
import { EtudiantListComponent } from './etudiant-list/etudiant-list.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { CreateEtudiantComponent } from './create-etudiant/create-etudiant.component';
import { UpdateEtudiantComponent } from './update-etudiant/update-etudiant.component';
import { EtudiantDetailsComponent } from './etudiant-details/etudiant-details.component';
import { UpdateNoteComponent } from './update-note/update-note.component';
import { NoteDetailsComponent } from './note-details/note-details.component';
import { ClasseListComponent } from './classe-list/classe-list.component';
import { CreateClasseComponent } from './create-classe/create-classe.component';
import { UpdateClasseComponent } from './update-classe/update-classe.component';
import { ClasseDetailsComponent } from './classe-details/classe-details.component';
import { LoginComponent } from './login/login.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';


@NgModule({
  declarations: [
    AppComponent,
    MatiereListComponent,
    CreateMatiereComponent,
    UpdateMatiereComponent,
    MatiereDetailsComponent,
    NoteListComponent,
    NoteComponent,
    CreateNoteComponent,
    EtudiantListComponent,
    EtudiantComponent,
    CreateEtudiantComponent,
    UpdateEtudiantComponent,
    EtudiantDetailsComponent,
    UpdateNoteComponent,
    NoteDetailsComponent,
    ClasseListComponent,
    CreateClasseComponent,
    UpdateClasseComponent,
    ClasseDetailsComponent,
    LoginComponent,
    AdminTemplateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
