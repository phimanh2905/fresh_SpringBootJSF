import {UserService} from '../service/user.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../models/user.model';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  userid: any;
  user: User;
  testSession: boolean;
  constructor(private router: ActivatedRoute, private userService: UserService, private route: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('userData') == null) {
      this.testSession = false;
    } else {
    this.testSession = true;
    }
    this.router.params.subscribe(params => {
    this.userid = params['id'];
    this.userService.getUserbyID(this.userid)
        .subscribe( data => {
          this.user = data;
        });
  });
  }
  updateUser(): void {
    this.userService.updateUser(this.user)
        .subscribe( data => {
          alert('Sửa thành công.');
          sessionStorage.setItem('userData', 'xxx');
          // test
          if (sessionStorage.getItem('userData') == null) {
            this.testSession = false;
          } else {
          this.testSession = true;
    }
        });
  }
  logout() {
    sessionStorage.removeItem('userData');
    if (sessionStorage.getItem('userData') == null) {
      this.testSession = false;
    } else {
    this.testSession = true;
    }
    this.route.navigate([this.router.url]);
  }
}
