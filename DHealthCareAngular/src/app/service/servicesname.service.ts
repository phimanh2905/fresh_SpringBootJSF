import {Injectable} from '@angular/core';

import { ServiceName } from '../models/servicesname.model';

@Injectable()
export class ServicesNameService {

  constructor() {}

  //private domain = 'http://192.188.88.119:8090';
  //==============================================

  public getAllServices() {

    let sv1 = new ServiceName('','','','');
    let sv2 = new ServiceName('','','','');
    let sv3 = new ServiceName('','','','');
    let sv4 = new ServiceName('','','','');
    let sv5 = new ServiceName('','','','');
    let sv6 = new ServiceName('','','','');
    let sv7 = new ServiceName('','','','');
    let sv8 = new ServiceName('','','','');

    services: ServiceName[] = [sv1,sv2,sv3,sv4,sv5,sv6,sv7,sv8];

    return services;
  }
 }
