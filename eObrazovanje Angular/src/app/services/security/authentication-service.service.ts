import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Korisnik } from 'src/app/model/korisnik';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  
  private API = "/api/signin"
  constructor(private http : HttpClient) { }

  authentication(korisnik : Korisnik) : Observable<any>{
    return this.http.post(this.API, korisnik);
  }


}
