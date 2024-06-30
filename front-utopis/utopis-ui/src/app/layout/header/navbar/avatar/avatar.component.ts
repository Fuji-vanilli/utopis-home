import {Component, effect, inject, OnInit} from '@angular/core';
import { KeycloakEvent, KeycloakEventType, KeycloakService } from 'keycloak-angular';
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

  constructor() {
    this.kcService.keycloakEvents$.subscribe(
      (event: KeycloakEvent)=> {
        if (event.type === KeycloakEventType.OnAuthSuccess) {
          console.log('success login');
        }
      }
    )
  }

  ngOnInit(): void {
    this.getUserConnected();
  }

  login() {
    this.kcService.login(); 
  }

  getUserConnected() {
    this.userService.getUserConnected().subscribe({
      next: user=> {
        this.user= user;
        console.log('username: '+this.user?.username);
        
      }
    })
  }
  
  logout() {
    this.kcService.logout(window.location.origin);
  }

}
