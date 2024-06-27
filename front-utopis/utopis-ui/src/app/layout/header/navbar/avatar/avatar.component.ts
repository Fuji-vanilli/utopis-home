import {Component, effect, inject, OnInit} from '@angular/core';
import {AuthService} from "../../../../services/auth.service";
import {Location} from "@angular/common";
import {User} from "../../../../models/user.model";
import { log } from 'console';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrl: './avatar.component.scss'
})
export class AvatarComponent  implements OnInit{
  authService= inject(AuthService);
  location= inject(Location);

  connectedUser:User= {email: this.authService.notConnected};

  user: User | undefined;


  constructor() {
    effect(() => {
      if (this.authService.fetchUser().status== 'OK') {
        this.connectedUser= this.authService.fetchUser().value!;
      }
    });
  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }

  ngOnInit(): void {
    this.authService.fetchUserDetails().subscribe({
      next: user=> {
        this.user= {
          username: user.username,
          firstname: user.firstname,
          email: user.email,
          imageUrl: user.imageUrl
        }
      },
      error: err=> {
        console.log("error to fetch user details::");
        
      }
    })
  }

}
