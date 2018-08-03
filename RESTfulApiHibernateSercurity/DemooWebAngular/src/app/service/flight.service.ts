import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Customer } from '../models/customer.model';
import { Airline } from '../models/airline.model';
import { FlightSchedules } from '../models/flightschedules.model';
import { PaymentMethod } from '../models/paymentmethod.model';
import { Reservation } from '../models/reservation.model';
import { ReservationStatus } from '../models/reservationstatus.model';
import { User } from '../models/user.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class FlightService {

  constructor(private http: HttpClient) {}

  private domain = 'http://192.188.88.119:8090';
  //==============================================
  public getAllLstFlight() {
    return this.http.get<FlightSchedules[]>(this.domain + '/api/flights');
  }
  public getLstReservation(phone) {
    return this.http.get<Reservation[]>(this.domain + '/api/reservation_p/' + phone);
  }
  public getAllLstPaymentmethod() {
    return this.http.get<PaymentMethod[]>(this.domain + '/api/paymentmethods');
  }
  //====================================================
  public getFlightbyID(id) {
    return this.http.get<FlightSchedules>(this.domain + '/api/flight/' + id);
  }
  public getReservationStatusbyID(id) {
    return this.http.get<ReservationStatus>(this.domain + '/api/reservation_status/' + id);
  }
  public getPaymentMethodbyID(id) {
    return this.http.get<PaymentMethod>(this.domain + '/api/paymentmethod/' + id);
  }
  public getCustomerbyPhone(phone) {
    return this.http.get<Customer>(this.domain + '/api/customer/' + phone);
  }
  //====================================================
//  public deleteUser(user) {
//    return this.http.delete(this.userUrl + "/"+ user.id);
//  }

  public createCustomer(customer) {
    return this.http.post<Customer>(this.domain + '/api/customer', customer);
  }
  public createReservation(CustomerID, FlightID, PayID, SttID, date) {
    return this.http.post(this.domain + '/api/reservation', {
      customerID: CustomerID,
      flightSchedulesID: FlightID,
      paymnetMethodID: PayID,
      reservationStatusID: SttID,
      dateOfReservation: date
    });
  }
  //======================================================
//  public updateUser(user) {
//    return this.http.put<User>(this.userUrl, user);
//  }
  
 }