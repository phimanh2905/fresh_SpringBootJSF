import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TrangchuComponent } from './pages/trangchu/trangchu.component';
import { ServicesComponent } from './pages/services/services.component';
import { AboutusComponent } from './pages/aboutus/aboutus.component';
import { BlogComponent } from './pages/blog/blog.component';
import { ContactsComponent } from './pages/contacts/contacts.component';
import { RequestanappointmentComponent } from './pages/requestanappointment/requestanappointment.component';
import { PagenotfoundComponent } from './pages/pagenotfound/pagenotfound.component';

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  { path: 'index', component: TrangchuComponent },
  { path: 'services', component: ServicesComponent },
  { path: 'aboutus', component: AboutusComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'contacts', component: ContactsComponent },
  { path: 'request', component: RequestanappointmentComponent },
  { path: 'notfound', component: PagenotfoundComponent }
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
