import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {EditUserComponent} from './edit-user/edit-user.component';
import { FlightsComponent } from './pages/flights/flights.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'flights', component: FlightsComponent },
  { path: 'customers', component: CustomerComponent },
  { path: 'edit/:id', component: EditUserComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
