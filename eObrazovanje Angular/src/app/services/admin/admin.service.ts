import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class AdminService {
  
  constructor(private http: HttpClient) {}

 

  // save(admin: Admin) {
  //   return this.http.post(ADMIN_API + "add", admin, { headers: this.headers });
  // }
}
