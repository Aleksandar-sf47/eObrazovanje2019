import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private API = "/api/signin"
  constructor(private http : HttpClient) { }

  authentication(loginDTO){
    return this.http.post(this.API, loginDTO);
  }
}
