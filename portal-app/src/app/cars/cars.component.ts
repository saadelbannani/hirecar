import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Car } from '../model/car.model';
import { CarService } from '../service/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: []
})

export class CarsComponent implements OnInit {

  cars: Car[];

  constructor(private router: Router, private carService: CarService) { }

  ngOnInit() {
    this.carService.getCars().subscribe( data => {
      this.cars = data;
      });
  };

}
