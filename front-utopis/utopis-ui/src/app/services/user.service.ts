import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpClient= inject(HttpClient);

  constructor() { }

  getAuthResource(): Observable<any> {
    return this.httpClient.get(environment.API_URL+'/api/user/get-resource');
  }
}
