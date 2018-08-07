/**
 * New typescript file
 */
import {Customer} from './customer.model';
import {PaymentMethod} from './paymentmethod.model';
import {ReservationStatus} from './reservationstatus.model';
import {FlightSchedules} from './flightschedules.model';
export class Reservation {
  rid: number;
  customer: Customer;
  flightSchedules: FlightSchedules;
  paymnetMethod: PaymentMethod;
  reservationStatus: ReservationStatus;
  dateOfReservation: Date;
}
