import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";

import {AppComponent} from './app.component';
import {ApartmentListComponent} from './apartment-list/component/apartment-list.component';
import {AppRoutingModule} from './app-routing.module';
import {CreateApartmentComponent} from './create-apartment/component/create-apartment.component';
import {ApartmentComponent} from './apartment/component/apartment.component';

@NgModule({
  declarations: [
    AppComponent,
    ApartmentListComponent,
    CreateApartmentComponent,
    ApartmentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: 'routes',
        component: AppRoutingModule
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
