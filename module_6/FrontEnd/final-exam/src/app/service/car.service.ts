import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Car} from "../model/car";

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private api_url = "http://localhost:8080/car";

  constructor(private httpClient: HttpClient) {
  }

  findAll(currentPage): Observable<Car[] | any> {
    return this.httpClient.get(this.api_url+"?page="+currentPage);
  }


  findById(id: number): Observable<Car | any> {
    return this.httpClient.get(this.api_url + '/find/' + id);
  }

  delete(id: number): Observable<Car | any> {
    return this.httpClient.delete(this.api_url + '/delete/' + id);
  }

  update(id: number, editCar: Car): Observable<Car | any> {
    return this.httpClient.put(this.api_url + '/update', editCar);
  }

  create(newCar: Car): Observable<Car | any> {
    return this.httpClient.post(this.api_url + '/add', newCar)
  }
}
