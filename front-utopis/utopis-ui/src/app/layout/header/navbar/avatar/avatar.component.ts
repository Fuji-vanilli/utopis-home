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

  result: string | undefined;


  constructor() {
    effect(() => {
      if (this.authService.fetchUser().status== 'OK') {
        this.connectedUser= this.authService.fetchUser().value!;
      }
    });
  }

  getTest() {
    this.authService.fetchTest().subscribe({
      next: resp=> {
        this.result= resp;
        console.log('resp: ', resp);
        
      }
    })
  }

  login() {
    this.authService.login().subscribe({
      next: response=> {
        console.log("successed connexion");
        
      }
    });
  }

  logout() {
    this.authService.logout();
  }

  ngOnInit(): void {
    this.getTest();
  }

}
