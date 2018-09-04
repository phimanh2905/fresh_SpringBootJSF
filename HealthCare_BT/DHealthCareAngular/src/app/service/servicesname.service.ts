import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { SERVICE_ITEMS } from '../data/services.data';
import { ServiceName } from '../models/servicesname.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ServicesNameService {
  private services = SERVICE_ITEMS;
  constructor(private http: HttpClient) {}

//  private domain = 'http://192.188.88.119:8090';
  //==============================================
//    public getAllServices() {
//      return this.http.get<ServiceName[]>(this.domain + '/api/services');
//  }
  //==============================================
    public getAllServices() {
      return this.services;
    }
 }
