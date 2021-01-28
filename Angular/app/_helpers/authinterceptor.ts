import { HTTP_INTERCEPTORS, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

import { TokenserviceService } from '../tokenservice.service'
import { Observable } from 'rxjs';
const TOKEN_HEADER_KEY = 'Authorization';
@Injectable()

export class Authinterceptor {
    constructor(private token: TokenserviceService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    const token = this.token.getToken();
   console.log(this.token.getToken());
    if (token != null) {
      
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });

      
    }
    return next.handle(authReq);
  }


}

export const authInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: Authinterceptor, multi: true }
  ];


