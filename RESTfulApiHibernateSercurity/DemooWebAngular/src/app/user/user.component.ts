import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: []
})
export class UserComponent implements OnInit {

  users: User[];
  @ViewChild('xcxcc') comptest: ElementRef<any>;
  constructor(private router: Router, private userService: UserService) {

  }

  ngOnInit() {
    this.userService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  };

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
        alert('Xóa thành công');
      })
  };

    testput(user : User){
      this.comptest.nativeElement.value = user.firstName +" "+ user.lastName;
    };
}


