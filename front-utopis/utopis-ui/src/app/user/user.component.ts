import { Component, OnInit, inject } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../models/user.model';
import { PropertyService } from '../services/property.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent implements OnInit {

    userService= inject(UserService);
    propertyService= inject(PropertyService);

    email: string= 'NOT_EMAIL_FOUND';
    user: User | undefined;

    ngOnInit(): void {
      this.userService.getUserConnected().subscribe({
        next: response=> {
          this.user= response;
          console.log('email: '+this.user?.email);
          
        }
      });

      this.propertyService.getAll().subscribe({
        next: response=> {
          console.log("property: "+response);
          
        },
        error: err=> {
          console.log('error:'+err);
          console.log(err);
          
          
        }
      }) 
    }

}
