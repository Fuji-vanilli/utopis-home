import { Component, OnInit, inject } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent implements OnInit {

    userService= inject(UserService);

    email: string= 'NOT_EMAIL_FOUND';

    ngOnInit(): void {
      this.userService.getAuthResource().subscribe({
        next: response=> {
          this.email= response.tokenAttributes.email;
          console.log('email: '+this.email);
          
        }
      })
    }

}
