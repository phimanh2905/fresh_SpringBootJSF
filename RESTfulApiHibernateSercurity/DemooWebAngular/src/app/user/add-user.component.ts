import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import {UserService} from '../service/user.service';

@Component({
  templateUrl: './add-user.component.html'
})
export class AddUserComponent  {
  user: User = new User();
  
  constructor(private router: Router, private userService: UserService) {

  }

  createUser() {
    this.userService.createUser(this.user)
        .subscribe( data => {
          alert('Thêm thành công.');
          this.user = new User();
         
        });

  }
  

}
