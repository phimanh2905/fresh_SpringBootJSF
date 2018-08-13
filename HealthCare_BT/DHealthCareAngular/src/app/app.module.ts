import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app.routing.module';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { TrangchuComponent } from './pages/trangchu/trangchu.component';
import { AboutusComponent } from './pages/aboutus/aboutus.component';
import { BlogComponent } from './pages/blog/blog.component';
import { ContactsComponent } from './pages/contacts/contacts.component';
import { PagenotfoundComponent } from './pages/pagenotfound/pagenotfound.component';
import { RequestanappointmentComponent } from './pages/requestanappointment/requestanappointment.component';
import { ServicesComponent } from './pages/services/services.component';
import {ServicesNameService} from './service/servicesname.service';


@NgModule({
  declarations: [
    AppComponent,
    TrangchuComponent,
    AboutusComponent,
    BlogComponent,
    ContactsComponent,
    PagenotfoundComponent,
    RequestanappointmentComponent,
    ServicesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServicesNameService],
  bootstrap: [AppComponent]
})
export class AppModule { }
