import { Component, OnInit, OnChanges } from '@angular/core';
import { UcenikService } from 'src/app/services/ucenik/ucenik.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ucenici-detalji',
  templateUrl: './ucenici-detalji.component.html',
  styleUrls: ['./ucenici-detalji.component.css']
})
export class UceniciDetaljiComponent implements OnInit, OnChanges {

  private id : number;
  ucenik;
  btnEdit : boolean = false; //za otvaranje forme za edit

  constructor(private route : ActivatedRoute, private uServ : UcenikService) { }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    console.log(this.id);
    this.uServ.getUcenik(this.id).subscribe(res=>{
        console.log(res);
        this.ucenik = res;
    });
  }

  ngOnChanges(){
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    console.log(this.id);
    this.uServ.getUcenik(this.id).subscribe(res=>{
        console.log(res);
        this.ucenik = res;
    });
  }

  btnEditClick(){
    this.btnEdit = true;
  }

  editUcenik(){
    this.btnEdit = false;
    this.ngOnChanges();
  }

  btnDeleteClick(){
    this.uServ.deleteUcenik(this.id).subscribe(res=>{
      console.log(res);
      window.location.href = "";
    });
  }

}
