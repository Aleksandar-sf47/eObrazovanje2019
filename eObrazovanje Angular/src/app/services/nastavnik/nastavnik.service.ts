import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Nastavnik } from 'src/app/model/nastavnik';

@Injectable({
  providedIn: 'root'
})
export class NastavnikService {

  private API = "api/nastavnici";
  constructor(private http: HttpClient) {}

  getNastavnici(): Observable<any> {
    return this.http.get(this.API);
  }

  getNastavnik(id) : Observable<any>{
    return this.http.get(this.API + "/" + id);
  }

  postNastavnik(nastavnikDTO) : Observable<any>{
    return this.http.post(this.API, nastavnikDTO);
  }

  putNastavnik(id ,nastavnikDTO) : Observable<any>{
    return this.http.put(this.API + "/" + id, nastavnikDTO);
  }

  deleteNastavnik(id) : Observable<any>{
    return this.http.delete(this.API + "/" + id);
  }

  getListaPredavanja(id) : Observable<any>{
    return this.http.get(this.API+ "/" + id + "/predavanja")
  }
}
