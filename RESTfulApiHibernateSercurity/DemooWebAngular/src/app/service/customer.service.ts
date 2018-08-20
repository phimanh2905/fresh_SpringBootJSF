import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { Customer } from '../models/customer.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) {}
//  private domain = "http://192.168.11.105:8090";
  private domain = 'http://192.188.88.119:8090';
  //==============================================

  public getLstCustomer() {
    return this.http.get<Customer[]>(this.domain + '/api/customers/');
  }
 }