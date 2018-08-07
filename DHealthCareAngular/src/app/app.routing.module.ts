import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TrangchuComponent } from './pages/trangchu/trangchu.component';


const routes: Routes = [
  { path: 'index', component: TrangchuComponent }

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
