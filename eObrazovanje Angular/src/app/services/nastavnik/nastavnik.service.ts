import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NastavnikService {

  private API = "api/nastavnici";
  constructor(private http: HttpClient) {}

  getNastavnici(): Observable<any> {
    return this.http.get(this.API);
  }

  postNastavnik(nastavnikDTO) : Observable<any>{
    return this.http.post(this.API, nastavnikDTO);
  }
}
