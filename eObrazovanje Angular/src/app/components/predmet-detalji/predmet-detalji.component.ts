import { Component, OnInit } from '@angular/core';
import { PredmetComponent } from '../predmet/predmet.component';
import { PredmetService } from 'src/app/services/predmet/predmet.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-predmet-detalji',
  templateUrl: './predmet-detalji.component.html',
  styleUrls: ['./predmet-detalji.component.css']
})
export class PredmetDetaljiComponent implements OnInit {
  id;
  predmet;
  constructor(private pServ : PredmetService, private route : ActivatedRoute) { }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    this.pServ.getPredmet(this.id).subscribe(res=>{
      console.log(res);
      this.predmet = res;
    });
  }

}
