import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PredmetService {

  private API = "api/predmeti";
  constructor(private http : HttpClient) { }

  getPredmeti(): Observable<any> {
    return this.http.get(this.API);
  }

  getPredmet(id) : Observable<any>{
    return this.http.get(this.API + "/" + id);
  }

  postPredmet(PredmetDTO) : Observable<any>{
    return this.http.post(this.API, PredmetDTO);
  }

  putPredmet(id ,PredmetDTO) : Observable<any>{
    return this.http.put(this.API + "/" + id, PredmetDTO);
  }

  deletePredmet(id) : Observable<any>{
    return this.http.delete(this.API + "/" + id);
  }
}
