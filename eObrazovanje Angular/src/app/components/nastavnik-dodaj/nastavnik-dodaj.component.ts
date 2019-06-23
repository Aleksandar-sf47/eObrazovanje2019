import { Component, OnInit, Input } from '@angular/core';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';

@Component({
  selector: 'app-nastavnik-dodaj',
  templateUrl: './nastavnik-dodaj.component.html',
  styleUrls: ['./nastavnik-dodaj.component.css']
})
export class NastavnikDodajComponent implements OnInit {

  @Input() nastavnik;

  nastavnikDTO = {
    ime : "",
    prezime : "",
    jmbg : "",
    email : "",
    telefon : "",
    korisnickoIme : "",
    sifra : ""
};
  constructor(private nServ : NastavnikService) { }

  ngOnInit() {
  }

  submit(){
    console.log(this.nastavnikDTO);
    this.nServ.postNastavnik(this.nastavnikDTO).subscribe(res => {
      console.log(res);
    });
  }

}
