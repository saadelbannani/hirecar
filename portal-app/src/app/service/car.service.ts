import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Car } from '../model/car.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CarService {

  constructor(private http:HttpClient) { }

  private carUrl = '/car';

  public getCars() {
    return this.http.get<Car[]>(this.carUrl);
  }
}

