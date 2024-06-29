import {Component, effect, inject, OnInit} from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrl: './avatar.component.scss'
})
export class AvatarComponent  implements OnInit{

  kcService= inject(KeycloakService);

  ngOnInit(): void {

  }
  
  logout() {
    this.kcService.logout(window.location.origin);
  }

}
