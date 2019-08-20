import { Component, OnInit, OnChanges } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nastavnik',
  templateUrl: './nastavnik.component.html',
  styleUrls: ['./nastavnik.component.css']
})
export class NastavnikComponent implements OnInit, OnChanges {

  constructor(private nastavnikService : NastavnikService,
              private router : Router) { }
  nastavnici = [];
  nastavnikDodaj : boolean = false; //sluzi za prikaz forme dodavanje nastavnika
  nastavnik;

  ngOnInit() {
    this.nastavnikService.getNastavnici().subscribe(res => {
      this.nastavnici = res;
    });
  }

  ngOnChanges(){
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
    this.router.navigate(["nastavnik-details/" + this.nastavnik.id])
  }

  newNastavnik(){
    this.nastavnikDodaj = false; //zatvara formu za dodavanje nastavnika
    this.ngOnChanges();
  }
}
