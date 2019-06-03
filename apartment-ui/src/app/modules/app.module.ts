import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CustomMaterialModule } from './shared/custom-material.module';

import { AppComponent } from './app.component';
import { ApartmentListComponent } from './apartments/apartment-list/apartment-list.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateApartmentComponent } from './apartments/apartment-create/create-apartment.component';
import { ApartmentComponent } from './apartments/apartment/apartment.component';
import { HeaderComponent } from './shared/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    ApartmentListComponent,
    CreateApartmentComponent,
    ApartmentComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: 'routes',
        component: AppRoutingModule,
      },
    ]),
    CustomMaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
