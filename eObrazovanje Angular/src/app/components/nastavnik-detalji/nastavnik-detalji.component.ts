import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';
import { Nastavnik } from 'src/app/model/nastavnik';

@Component({
  selector: 'app-nastavnik-detalji',
  templateUrl: './nastavnik-detalji.component.html',
  styleUrls: ['./nastavnik-detalji.component.css']
})
export class NastavnikDetaljiComponent implements OnInit, OnChanges {

  private id : number;
  nastavnik : Nastavnik;
  btnEdit : boolean = false; //za otvaranje forme za edit
  listaPredavanja = [];

  constructor(private route : ActivatedRoute, private nServ : NastavnikService) { }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    console.log(this.id);
    this.nServ.getNastavnik(this.id).subscribe(res=>{
        console.log(res);
        this.nastavnik = new Nastavnik().deserializable(res);
    });
    this.nServ.getListaPredavanja(this.id).subscribe(res=>{
      this.listaPredavanja = res;
    });

    
  }

  ngOnChanges(){
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    console.log(this.id);
    this.nServ.getNastavnik(this.id).subscribe(res=>{
        console.log(res);
        this.nastavnik = new Nastavnik().deserializable(res);
    });
  }

  btnEditClick(){
    this.btnEdit = true;
  }

  editNastavnik(){
    this.btnEdit = false;
    this.ngOnChanges();
  }

  btnDeleteClick(){
    this.nServ.deleteNastavnik(this.id).subscribe(res=>{
      console.log(res);
      window.location.href = "";
    });
  }

  

}
