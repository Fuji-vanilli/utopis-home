import {HttpClient, HttpErrorResponse, HttpStatusCode} from '@angular/common/http';
import {computed, inject, Injectable, signal, WritableSignal} from '@angular/core';
import {State} from "../models/state.model";
import {User} from "../models/user.model";
import {Location} from "@angular/common";
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpClient= inject(HttpClient);
  location= inject(Location);

  notConnected: string= 'NOT-CONNECTED';

  private fetchUser$: WritableSignal<State<User, HttpErrorResponse>> =
    signal(State.Builder<User, HttpErrorResponse>().forSuccess({email: this.notConnected}).build());

  fetchUser = computed(() => this.fetchUser$());
  constructor() { }

  fetch() {
    this.httpClient.get('${environment.APP_URL}/api/user/get-authenticated-user').subscribe({
      next: user=> this.fetchUser$.set(State.Builder<User, HttpErrorResponse>().forSuccess(user).build()),
      error: (err: HttpErrorResponse) => {
        if (err.status === HttpStatusCode.Unauthorized && this.isAuthenticated()) {
          this.fetchUser$.set(State.Builder<User, HttpErrorResponse>().forSuccess({email: this.notConnected}).build());
        } else {
          this.fetchUser$.set(State.Builder<User, HttpErrorResponse>().forError(err).build());
        }
      }
    })
  }

  isAuthenticated(): boolean {
    if (this.fetchUser$().value) {
      return this.fetchUser$().value!.email !== this.notConnected;
    } else {
      return false;
    }
  }

  login(): void {
    location.href = `${location.origin}${this.location.prepareExternalUrl('oauth2/authorization/okta')}`;
  }

  logout(): void {
    this.httpClient.post(`${environment.APP_URL}/api/logout`, {}, {withCredentials: true})
      .subscribe({
        next: (response: any) => {
          this.fetchUser$.set(State.Builder<User, HttpErrorResponse>().forSuccess({email: this.notConnected}).build());
          location.href = response.logoutUrl
        }
      })
  }


}
