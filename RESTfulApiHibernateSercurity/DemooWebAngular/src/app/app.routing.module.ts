import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {EditUserComponent} from './edit-user/edit-user.component';
import { FlightComponent } from './pages/flight/flight.component';

const routes: Routes = [
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'flights', component: FlightComponent },
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
