import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';

@Component({
  selector: 'app-nastavnik',
  templateUrl: './nastavnik.component.html',
  styleUrls: ['./nastavnik.component.css']
})
export class NastavnikComponent implements OnInit {

  constructor(private nastavnikService : NastavnikService) { }
  nastavnici = [];
  nastavnikDodaj : boolean = false; //sluzi za prikaz forme dodavanje nastavnika
  nastavnik;

  ngOnInit() {
    this.nastavnikService.getNastavnici().subscribe(res => {
      this.nastavnici = res;
    });
  }

  showNastavnikDodaj(){
      this.nastavnikDodaj = true;
  }


  selectedNastavnik(n){
    console.log(n);
    this.nastavnik = n;
    window.location.href = "nastavnik-details/" + this.nastavnik.id;
  }

  newNastavnik(n){
    this.nastavnici.push(n);
    this.nastavnikDodaj = false; //zatvara formu za dodavanje nastavnika
  }
}
