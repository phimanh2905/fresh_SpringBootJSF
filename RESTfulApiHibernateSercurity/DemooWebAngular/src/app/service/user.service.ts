import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http:HttpClient) {}
  private userUrl = 'http://192.168.11.105:8080/users';
  //private userUrl = 'http://192.188.88.119:8080/users';
  //private userUrl = '/api';

  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }
  public getUserbyID(id) {
    return this.http.get<User>(this.userUrl + "/"+ id);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }
  public updateUser(user) {
    return this.http.put<User>(this.userUrl, user);
  }
}


//const req = this.http.post('http://jsonplaceholder.typicode.com/posts', {
//      title: 'foo',
//      body: 'bar',
//      userId: 1
//    })