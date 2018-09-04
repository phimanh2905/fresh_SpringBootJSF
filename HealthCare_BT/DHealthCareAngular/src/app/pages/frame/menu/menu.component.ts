import { Directive,Component, OnInit, Input } from '@angular/core';
import {ServicesNameService} from '../../../service/servicesname.service';
import { ServiceName } from '../../../models/servicesname.model';
//import '../../../assets/js/super_guacamole_min.js';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})

export class MenuComponent implements OnInit {
  services: ServiceName[];
  constructor( private servicesnamex: ServicesNameService) { }

  ngOnInit() {
    this.services = this.servicesnamex.getAllServices();
//    this.servicesnamex.getAllServices()
//      .subscribe( data => {
//        this.services = data;
//      });
  }

}
