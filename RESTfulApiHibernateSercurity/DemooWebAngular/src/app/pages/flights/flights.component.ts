import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FlightSchedules} from '../../models/flightschedules.model';
import {FlightService} from '../../service/flight.service';


@Component({
  selector: 'app-flights',
  templateUrl: './flights.component.html',
  styleUrls: ['./flights.component.css'],
  styles: []
})
export class FlightsComponent implements OnInit {
  flights: FlightSchedules[];
  constructor(private router: Router, private flightService: FlightService) { }

  ngOnInit() {
      this.flightService.getAllLstFlight()
      .subscribe( data => {
        this.flights = data;
      });
  }

}
