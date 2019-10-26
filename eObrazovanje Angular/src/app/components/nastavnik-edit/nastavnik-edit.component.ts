import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';
import { Nastavnik } from 'src/app/model/nastavnik';

@Component({
  selector: 'app-nastavnik-edit',
  templateUrl: './nastavnik-edit.component.html',
  styleUrls: ['./nastavnik-edit.component.css']
})
export class NastavnikEditComponent implements OnInit {

  @Input("id") id : number;
  @Output() eeEditNastavnik = new EventEmitter();
  nastavnik;
  
  constructor(private nServ : NastavnikService) { }

  ngOnInit() {
    this.nServ.getNastavnik(this.id).subscribe(res=>{
      this.nastavnik = res;
    });
  }

  editNastavnik(){
    this.eeEditNastavnik.emit();
  }

  submit(){
    this.nServ.putNastavnik(this.id, this.nastavnik).subscribe(res=>{
      console.log(res);
      this.eeEditNastavnik.emit();
    });
  }

}
