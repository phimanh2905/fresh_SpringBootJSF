import {Airline} from './airline.model';

export class FlightSchedules {
  fid: number;
  airline: Airline;
  FFrom: string;
  FTo: string;
  arrivalTime: number;
  departureTime: Date;
  ortherDetails: string;
}
