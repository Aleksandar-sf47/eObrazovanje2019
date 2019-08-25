import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eObrazovanje2019';
  korisnik;

  constructor(private router : Router){
    this.korisnik = sessionStorage.getItem("kIme");
  }

  logout(){
    this.router.navigate([""]).then(()=>{
      location.reload();
    });
    
    
  }
}
