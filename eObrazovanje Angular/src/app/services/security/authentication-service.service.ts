import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  
  private API = "/api/signin"
  constructor(private http : HttpClient) { }

  authentication(loginDTO) : Observable<any>{
    return this.http.post(this.API, loginDTO);
  }


}
