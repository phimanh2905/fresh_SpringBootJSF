import { Component, OnInit } from '@angular/core';
import {ServicesNameService} from '../../service/servicesname.service';
import { ServiceName } from '../../models/servicesname.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trangchu',
  templateUrl: './trangchu.component.html',
  styleUrls: ['./trangchu.component.css']
})
export class TrangchuComponent implements OnInit {
  services: ServiceName[];
  constructor(private router: Router, private servicesnamex: ServicesNameService) { }

    ngOnInit() {
    this.services = this.servicesnamex.getAllServices();
//    this.servicesnamex.getAllServices()
//      .subscribe( data => {
//        this.services = data;
//      });
  }
}
