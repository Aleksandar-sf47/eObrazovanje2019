import { Component, OnInit, OnChanges } from '@angular/core';
import { UcenikService } from 'src/app/services/ucenik/ucenik.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ucenici',
  templateUrl: './ucenici.component.html',
  styleUrls: ['./ucenici.component.css']
})
export class UceniciComponent implements OnInit, OnChanges {
  ucenici = [];
  ucenik;
  ucenikDodaj : boolean = false; //sluzi za prikaz forme dodavanje ucenika

  constructor(private uServ : UcenikService, private router : Router) { }

  ngOnInit() {
    this.uServ.getUcenici().subscribe(res=>{
      this.ucenici = res;
    });
  }

  ngOnChanges(){
    this.uServ.getUcenici().subscribe(res=>{
      this.ucenici = res;
    });
  }

  selectedUcenik(u){
    this.ucenik = u;
    this.router.navigate(["ucenik-details/" + this.ucenik.id])
  }

  showUcenikDodaj(){
    this.ucenikDodaj = true;
  }

  newUcenik(){
    this.ucenikDodaj = false;
    this.ngOnChanges();
  }
}
