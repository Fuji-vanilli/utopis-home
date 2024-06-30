import { Component, OnInit, inject } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent implements OnInit {

    userService= inject(UserService);

    email: string= 'NOT_EMAIL_FOUND';
    user: User | undefined;

    ngOnInit(): void {
      this.userService.getUserConnected().subscribe({
        next: response=> {
          this.user= response;
          console.log('email: '+this.user?.email);
          
        }
      })
    }

}
