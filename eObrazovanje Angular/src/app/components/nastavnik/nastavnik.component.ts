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
  nastavnikDodaj : boolean = false;
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
  }
}
