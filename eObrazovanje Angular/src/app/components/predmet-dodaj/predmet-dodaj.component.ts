import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { PredmetService } from 'src/app/services/predmet/predmet.service';

@Component({
  selector: 'app-predmet-dodaj',
  templateUrl: './predmet-dodaj.component.html',
  styleUrls: ['./predmet-dodaj.component.css']
})
export class PredmetDodajComponent implements OnInit {

  predmetDTO = {
    naziv: ""
  }

  @Output() eeNewPredmet : any = new EventEmitter();
  constructor(private pServ : PredmetService) { }

  ngOnInit() {
  }

  submit(){
    this.pServ.postPredmet(this.predmetDTO).subscribe(res=>{
      console.log(res);
      this.newPredmet();
    });
  }

  newPredmet(){
    this.eeNewPredmet.emit();
  }

}
