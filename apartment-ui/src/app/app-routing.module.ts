import { NgModule } from '@angular/core';
import {APP_BASE_HREF} from '@angular/common';
import { RouterModule, Routes } from "@angular/router";

import { ApartmentListComponent } from "./apartment-list/component/apartment-list.component";
import { CreateApartmentComponent} from "./create-apartment/component/create-apartment.component";
import { ApartmentComponent } from './apartment/component/apartment.component';

const routes: Routes = [
  { path: 'create', component: CreateApartmentComponent },
  { path: 'list', component: ApartmentListComponent },
  { path: ':id', component: ApartmentComponent},
  { path: '', component: ApartmentListComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  declarations: [],
  exports: [ RouterModule ],
  providers: [{provide: APP_BASE_HREF, useValue: '/apartment/'}]
})
export class AppRoutingModule {}
