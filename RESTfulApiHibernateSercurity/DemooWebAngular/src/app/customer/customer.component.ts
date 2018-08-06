import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {Customer} from '../models/customer.model';
import {CustomerService} from '../service/customer.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
  styles: []
})
export class CustomerComponent implements OnInit {
  customers: Customer[];
  constructor(private router: Router, private customerService: CustomerService) { }

  ngOnInit() {
  	this.customerService.getLstCustomer()
      .subscribe( data => {
        this.customers = data;
      });
  }

}
