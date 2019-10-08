import { Component, OnInit, OnChanges } from '@angular/core';
import { PredmetService } from 'src/app/services/predmet/predmet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-predmet',
  templateUrl: './predmet.component.html',
  styleUrls: ['./predmet.component.css']
})
export class PredmetComponent implements OnInit, OnChanges {

  predmeti = [];
  predmetDodaj : boolean = false; //sluzi za prikaz forme dodavanje predmeta
  predmet = {id: "", naziv : ""};
  

  constructor(private pServ : PredmetService, private router : Router) { }

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

  sendToDetails(){
    this.router.navigate(["predmet-details/" + this.predmet.id]);
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
