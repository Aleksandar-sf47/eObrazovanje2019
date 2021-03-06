import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { NastavnikService } from "src/app/services/nastavnik/nastavnik.service";

@Component({
  selector: "app-nastavnik-dodaj",
  templateUrl: "./nastavnik-dodaj.component.html",
  styleUrls: ["./nastavnik-dodaj.component.css"]
})
export class NastavnikDodajComponent implements OnInit {
  @Output() eeNewNastavnik: any = new EventEmitter();

  nastavnikDTO = {
    ime: "",
    prezime: "",
    jmbg: "",
    email: "",
    telefon: "",
    korisnikDTO: {
      korisnickoIme: "",
      sifra: "",
      listaUloga: []
    }
  };
  constructor(private nServ: NastavnikService) {}

  ngOnInit() {}

  submit() {
    console.log(this.nastavnikDTO);
    this.nServ.postNastavnik(this.nastavnikDTO).subscribe(res => {
      console.log(res);
      this.newNastavnik();
    });
  }

  newNastavnik() {
    this.eeNewNastavnik.emit();
  }
}
