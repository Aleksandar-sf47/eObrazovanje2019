import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  korisnik;
  ulogaKorisnika;


  constructor(private router : Router) {
    this.korisnik = sessionStorage.getItem("kIme");
    this.ulogaKorisnika = sessionStorage.getItem("uloga");
   }

  ngOnInit() {
  }

}
