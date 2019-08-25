import { Component, OnInit, OnChanges, Output, EventEmitter } from '@angular/core';
import { AuthenticationServiceService } from 'src/app/services/security/authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnChanges {

  @Output() logoutEmiter : EventEmitter<any> = new EventEmitter();
  private korisnik;
 
  constructor(private aServ : AuthenticationServiceService, private router : Router) {
    
   }

  ngOnInit() {
  }

  ngOnChanges(){
    
  }

  logout(){
    sessionStorage.clear();
    this.logoutEmiter.emit(event);
  
  
  }

}
