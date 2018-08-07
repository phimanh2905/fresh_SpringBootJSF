import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { AppUser } from '../models/appuser.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AppUserService {

  constructor(private http: HttpClient) {}

  private domain = 'http://192.188.88.119:8090';
  //==============================================

  public getUserbyID(name) {
    return this.http.get<AppUser>(this.domain + '/api/user/' + name);
  }
 }