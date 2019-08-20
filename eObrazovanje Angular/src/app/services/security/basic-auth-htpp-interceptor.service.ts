import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHtppInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log("Heeeejjjjjjjjjjjjjjjjjj");
    console.log(sessionStorage.getItem("kIme"));
    console.log(sessionStorage.getItem("token"));
    console.log(sessionStorage.getItem("tokenType") + " " + sessionStorage.getItem("token"));
    if (sessionStorage.getItem("kIme") && sessionStorage.getItem("token")) {
      req = req.clone({
        setHeaders: {
          Authorization: sessionStorage.getItem("tokenType") + " " + sessionStorage.getItem("token")
        }
      })
    }
    return next.handle(req);
  }
}
