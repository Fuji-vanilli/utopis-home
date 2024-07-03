import { Component, OnInit, inject } from '@angular/core';
import { PropertyService } from '../services/property.service';
import { Property } from '../models/property.model';
import { error, log } from 'console';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  propertyService= inject(PropertyService);
  properties: Property[] | undefined;

  ngOnInit(): void {
    this.propertyService.getAll().subscribe({
      next: response=> {
        this.properties= response;
        console.log("property: "+this.properties);
        
      },
      error: err=> {
        console.log('error:'+err);
        console.log(err);
        
        
      }
    }) 
  }

}
