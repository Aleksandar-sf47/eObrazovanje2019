import { Component, OnInit, OnChanges } from '@angular/core';
import { PredmetService } from 'src/app/services/predmet/predmet.service';

@Component({
  selector: 'app-predmet',
  templateUrl: './predmet.component.html',
  styleUrls: ['./predmet.component.css']
})
export class PredmetComponent implements OnInit, OnChanges {

  predmeti = [];
  predmetDodaj : boolean = false; //sluzi za prikaz forme dodavanje predmeta
  predmet;

  constructor(private pServ : PredmetService) { }

  ngOnInit() {
    this.pServ.getPredmeti().subscribe(res=>{
      this.predmeti = res;
    });
  }

  ngOnChanges(){
    this.pServ.getPredmeti().subscribe(res=>{
      this.predmeti = res;
    });
  }

  showPredmetDodaj(){
    this.predmetDodaj = true;
  }

  selectedPredmet(p){
    this.predmet = p;
  }

  btnDeleteClick(){
    this.pServ.deletePredmet(this.predmet.id).subscribe(res=>{
      console.log(res);
      this.ngOnChanges();
    });

  }

  newPredmet(){
    this.predmetDodaj = false;
    this.ngOnChanges();
  }

}
