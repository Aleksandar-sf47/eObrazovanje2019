import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UcenikService } from 'src/app/services/ucenik/ucenik.service';

@Component({
  selector: 'app-ucenik-dodaj',
  templateUrl: './ucenik-dodaj.component.html',
  styleUrls: ['./ucenik-dodaj.component.css']
})
export class UcenikDodajComponent implements OnInit {

  @Output() eeNewUcenik : any = new EventEmitter();

  ucenikDTO = {
    brojIndeksa : "",
    ime : "",
    prezime : "",
    jmbg : "",
    email : "",
    telefon : "",
    korisnickoIme : "",
    sifra : "",
    novcanik : ""
  };
  constructor(private uServ : UcenikService) { 

  }

  ngOnInit() {
  }

  submit(){
    this.uServ.postUcenik(this.ucenikDTO).subscribe(res=>{
        console.log(res);
        this.newUcenik();
    });
  }

  newUcenik(){
    this.eeNewUcenik.emit();
  }
}
