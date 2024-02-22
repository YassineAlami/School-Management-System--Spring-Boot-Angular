import { Injectable } from '@angular/core';
import {AppUser} from "./user.model";
import { v4 as uuidv4 } from 'uuid';
import {Observable, of} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";
import { throwError } from 'rxjs';

import * as ts from 'typescript';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  users: AppUser[] = [];
  authenticatedUser: AppUser | undefined;

  constructor() {
    this.users.push({ userId: uuidv4(), username: 'user1', password: 'password1', roles: ['USER'] });
    this.users.push({ userId: uuidv4(), username: 'user2', password: 'password1', roles: ['USER'] });
    this.users.push({ userId: uuidv4(), username: 'admin', password: 'password3', roles: ['ADMIN', 'USER']});
  }

  public login(username: string, password: string ) : Observable<AppUser>{
    let appUser = this.users.find(u => u.username==username);
    if (!appUser) return throwError(new Error("User Not Found"));
    if (appUser.password != password) return throwError(new Error("Bad Credentials"));

    return of(appUser);
  }

  public logout () : Observable<boolean>{
    this.authenticatedUser=undefined;
    localStorage.removeItem("authUser");
    return of(true);
  }

  public authenticateUser (appUser: AppUser) : Observable<boolean>{
    this.authenticatedUser=appUser;
    localStorage.setItem("authUser", JSON.stringify({username:appUser.username, roles:appUser.roles, jwt:"JWT_TOKEN"}));

    return of(true);
  }

  public hasRole(role: string) : boolean {
    return this.authenticatedUser!.roles.includes(role);
  }

  public isAuthenticated() : boolean {
    return this.authenticatedUser!=undefined;
  }

}
