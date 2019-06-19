import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class AdminService {
  private API = "api/nastavnici";
  constructor(private http: HttpClient) {}

  getNastavnici(): Observable<any> {
    return this.http.get(this.API);
  }

  // save(admin: Admin) {
  //   return this.http.post(ADMIN_API + "add", admin, { headers: this.headers });
  // }
}
