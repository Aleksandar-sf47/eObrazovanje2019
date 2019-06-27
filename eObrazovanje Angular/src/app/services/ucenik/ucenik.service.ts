import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UcenikService {

  private API = "api/ucenici";
  constructor(private http: HttpClient) { }

  getUcenici() : Observable<any>{
    return this.http.get(this.API);
  }

  getUcenik(id) : Observable<any>{
    return this.http.get(this.API + "/" + id);
  }

  postUcenik(ucenikDTO) : Observable<any>{
    return this.http.post(this.API, ucenikDTO);
  }

  putUcenik(id, ucenikDTO) : Observable<any>{
    return this.http.put(this.API + "/" + id, ucenikDTO);
  }

  deleteUcenik(id) : Observable<any>{
    return this.http.delete(this.API + "/" + id);
  }
}
