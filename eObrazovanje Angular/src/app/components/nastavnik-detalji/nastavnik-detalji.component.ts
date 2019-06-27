import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';

@Component({
  selector: 'app-nastavnik-detalji',
  templateUrl: './nastavnik-detalji.component.html',
  styleUrls: ['./nastavnik-detalji.component.css']
})
export class NastavnikDetaljiComponent implements OnInit {

  private id : number;
  nastavnik;
  btnEdit : boolean = false; //za otvaranje forme za edit

  constructor(private route : ActivatedRoute, private nServ : NastavnikService) { }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    console.log(this.id);
    this.nServ.getNastavnik(this.id).subscribe(res=>{
        console.log(res);
        this.nastavnik = res;
    });
    
  }

  btnEditClick(){
    this.btnEdit = true;
  }

  editNastavnik(n){
    this.btnEdit = false;
    this.nastavnik = n;
  }

  btnDeleteClick(){
    this.nServ.deleteNastavnik(this.id).subscribe(res=>{
      console.log(res);
      window.location.href = "";
    });
  }

  

}
