import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NastavnikService } from 'src/app/services/nastavnik/nastavnik.service';

@Component({
  selector: 'app-nastavnik-edit',
  templateUrl: './nastavnik-edit.component.html',
  styleUrls: ['./nastavnik-edit.component.css']
})
export class NastavnikEditComponent implements OnInit {

  @Input("id") id : number;
  @Output() eeEditNastavnik = new EventEmitter();
  nastavnikDTO;
  
  constructor(private nServ : NastavnikService) { }

  ngOnInit() {
    this.nServ.getNastavnik(this.id).subscribe(res=>{
      console.log("Prosledjen nastavnik: ");
      console.log(res);
      this.nastavnikDTO= res;
    });
  }

  editNastavnik(){
    this.eeEditNastavnik.emit();
  }

  submit(){
    this.nServ.putNastavnik(this.id, this.nastavnikDTO).subscribe(res=>{
      console.log(res);
      this.eeEditNastavnik.emit();
    });
  }

}
