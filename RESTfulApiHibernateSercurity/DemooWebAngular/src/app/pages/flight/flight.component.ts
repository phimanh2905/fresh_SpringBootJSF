import { Component, OnInit } from '@angular/core';
import {FlightSchedules} from '../../models/flightschedules.model';
import {FlightService} from '../../service/flight.service';

import { Router } from '@angular/router';
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styles: []
})
export class FlightComponent implements OnInit {
  flights: FlightSchedules[];
  constructor(private router: Router, private flightService: FlightService) { }

  ngOnInit() {
    this.flightService.getAllLstFlight()
      .subscribe( data => {
        this.flights = data;
      });
  }

}
