import { Component, OnInit } from '@angular/core';
import {ServicesNameService} from '../../service/servicesname.service';
import { ServiceName } from '../../models/servicesname.model';
//import { Router } from '@angular/router';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css'],
  styles: []
})
export class ServicesComponent implements OnInit {
  services: ServiceName[];
  constructor( private servicesnamex: ServicesNameService) { }

  ngOnInit() {
//    this.services = this.servicesnamex.getAllServices();
    this.servicesnamex.getAllServices()
      .subscribe( data => {
        this.services = data;
      });
  }

}
