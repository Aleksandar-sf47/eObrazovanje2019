import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { AuthenticationServiceService } from 'src/app/services/security/authentication-service.service';
import { Router } from '@angular/router';
import { Korisnik } from 'src/app/model/korisnik';
 

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {

 
  
  private korisnik : Korisnik = new Korisnik();

  constructor(private aServ : AuthenticationServiceService,
              private router : Router) {}

  ngOnInit() {}

  login() {
    console.log(this.korisnik);
    this.aServ.authentication(this.korisnik).subscribe(res => {
        console.log("Ovo je rezultat: " + "\n"
        + "korisnicko ime : " + res.username + "\n"
        + "uloga : " + res.authorities[0].authority + "\n"
        + "token : " + res.accessToken + "\n"
        + "token type : " + res.tokenType);

        sessionStorage.setItem("kIme", res.username)
        sessionStorage.setItem("uloga", res.authorities[0].authority)
        sessionStorage.setItem("token", res.accessToken)
        sessionStorage.setItem("tokenType", res.tokenType);
        location.reload();
        
        
    });
  }
}
