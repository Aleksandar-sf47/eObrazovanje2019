import { Component, OnInit, OnChanges, ViewChild } from '@angular/core';
import { PredmetComponent } from '../predmet/predmet.component';
import { PredmetService } from 'src/app/services/predmet/predmet.service';
import { ActivatedRoute } from '@angular/router';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';
import { UcenikService } from 'src/app/services/ucenik/ucenik.service';


@Component({
  selector: 'app-predmet-detalji',
  templateUrl: './predmet-detalji.component.html',
  styleUrls: ['./predmet-detalji.component.css']
})
export class PredmetDetaljiComponent implements OnInit, OnChanges {

  

  id;
  predmet;
  nastavnikPredavanje;
  ucenici : Array<any>;
  nastavnici;
  uceniciModal; // U modalu
  nastavniciModal; // U modalu 
  predavanjeDTO = {nastavnik:"", predmet:""};
  
  constructor(private pServ : PredmetService, private route : ActivatedRoute, private nServ : NastavnikService, private uServ : UcenikService) { }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    this.pServ.getPredmet(this.id).subscribe(res=>{
      console.log(res);
      this.predmet = res;
    });
    this.nServ.getNastavnici().subscribe(res=>{
      this.nastavniciModal = res;
    });

    this.uServ.getUcenici().subscribe(res=>{
      this.uceniciModal = res;
    });

    this.pServ.getPredavanje(this.id).subscribe(res=>{
      console.log("Predavanje rezultat : " + res);
      this.nastavnici = res;
    });

    }

    ngOnChanges(){
      this.nastavnici.push(this.nastavnikPredavanje);
    }


    selectedNastavnik(n){
      console.log(n);
      this.nastavnikPredavanje = n;
      this.predavanjeDTO.nastavnik = this.nastavnikPredavanje
      this.predavanjeDTO.predmet = this.predmet;
      console.log(this.predavanjeDTO);
      this.pServ.postPredavanje(this.predavanjeDTO.predmet.,this.predavanjeDTO).subscribe(res=>{
        console.log("Rezultat: " + res);
      
        document.getElementById('exampleModalCenter1').click();
      });
    }

}
