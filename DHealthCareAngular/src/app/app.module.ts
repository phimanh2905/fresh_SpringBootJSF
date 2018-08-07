import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TrangchuComponent } from './pages/trangchu/trangchu.component';
import { AboutusComponent } from './pages/aboutus/aboutus.component';
import { BlogComponent } from './pages/blog/blog.component';
import { ContactsComponent } from './pages/contacts/contacts.component';
import { PagenotfoundComponent } from './pages/pagenotfound/pagenotfound.component';
import { RequestanappointmentComponent } from './pages/requestanappointment/requestanappointment.component';
import { ServicesComponent } from './pages/services/services.component';


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
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
