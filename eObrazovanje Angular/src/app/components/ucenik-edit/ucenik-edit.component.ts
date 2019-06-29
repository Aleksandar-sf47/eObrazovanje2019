import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { UcenikService } from 'src/app/services/ucenik/ucenik.service';

@Component({
  selector: 'app-ucenik-edit',
  templateUrl: './ucenik-edit.component.html',
  styleUrls: ['./ucenik-edit.component.css']
})
export class UcenikEditComponent implements OnInit {

  @Input("id") id : number;
  @Output() eeEdidUcenik : any= new EventEmitter();
  ucenikDTO;
  constructor(private uServ : UcenikService) { }

  ngOnInit() {
    this.uServ.getUcenik(this.id).subscribe(res=>{
      console.log("Prosledjen ucenik: ");
      console.log(res);
      this.ucenikDTO= res;
    });
  }

  editUcenik(){
    this.eeEdidUcenik.emit();
  }

  submit(){
    this.uServ.putUcenik(this.id, this.ucenikDTO).subscribe(res=>{
      console.log(res);
      this.eeEdidUcenik.emit();
    });
  }
}
