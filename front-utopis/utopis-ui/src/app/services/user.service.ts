import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { env } from 'process';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpClient= inject(HttpClient);

  constructor() { }

  registerUser(): Observable<any> {
    return this.httpClient.get(environment.API_URL+'/USER-SERVICE/api/user/register-user');
  }

  getUserConnected(): Observable<any> {
    return this.httpClient.get(environment.API_URL+'/USER-SERVICE/api/user/get-authenticated-user');
  }
}
