import {Component, effect, inject, OnInit} from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { UserService } from '../../../../services/user.service';
import { User } from '../../../../models/user.model';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrl: './avatar.component.scss'
})
export class AvatarComponent  implements OnInit{

  kcService= inject(KeycloakService);
  userService= inject(UserService);

  user: User | undefined;

  ngOnInit(): void {

  }

  login() {
    this.kcService.login().then(
      ()=> this.userService.registerUser().subscribe({
        next: user=> {
          this.user= user;
          console.log('user: '+user);
          
        },
        error: err=> {
          console.log('error: '+err);
          
        }
      })
    );
  }
  
  logout() {
    this.kcService.logout(window.location.origin);
  }

}
