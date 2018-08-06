import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app.routing.module';
import {UserService} from './service/user.service';
import {CustomerService} from './service/customer.service';
import {FlightService} from './service/flight.service';
import {AppUserService} from './service/appuser.service';
import {HttpClientModule} from '@angular/common/http';
import {AddUserComponent} from './user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { FlightsComponent } from './pages/flights/flights.component';
import { CustomerComponent } from './customer/customer.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    EditUserComponent,
    FlightsComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService , FlightService , AppUserService , CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
