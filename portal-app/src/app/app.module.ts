import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CarsComponent } from './cars/cars.component';
import { AppRoutingModule } from './app.routing.module';
import { CarService } from './service/car.service';
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],

  providers: [CarService],

  bootstrap: [AppComponent]

})

export class AppModule { }
