import { Component, OnInit, OnChanges } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';
import { Router } from '@angular/router';
import { Nastavnik } from 'src/app/model/nastavnik';

@Component({
  selector: 'app-nastavnik',
  templateUrl: './nastavnik.component.html',
  styleUrls: ['./nastavnik.component.css']
})
export class NastavnikComponent implements OnInit, OnChanges {

  constructor(private nastavnikService : NastavnikService,
              private router : Router) { }
  nastavnici : Nastavnik[]= [];
  nastavnikDodaj : boolean = false; //sluzi za prikaz forme dodavanje nastavnika
  nastavnik : Nastavnik;

  ngOnInit() {
    this.nastavnikService.getNastavnici().subscribe(res => {
      res.forEach(element => {
        this.nastavnici.push(new Nastavnik().deserializable(element));
      });
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
    this.nastavnik = new Nastavnik().deserializable(n);
    console.log(this.nastavnik);
    this.router.navigate(["nastavnik-details/" + this.nastavnik.getId()]);
  }

  newNastavnik(){
    this.nastavnikDodaj = false; //zatvara formu za dodavanje nastavnika
    this.ngOnChanges();
  }
}
