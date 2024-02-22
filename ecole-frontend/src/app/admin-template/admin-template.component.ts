import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrls: ['./admin-template.component.css']
})
export class AdminTemplateComponent implements OnInit{

  constructor(public authService: AuthenticationService, private router:Router,
              public autheService : AuthenticationService) {

  }

  ngOnInit() {
  }

  handleLogout(){
    this.authService.logout().subscribe({
      next:(data)=> {
        this.router.navigateByUrl("login");
      }
    })
  }
}
