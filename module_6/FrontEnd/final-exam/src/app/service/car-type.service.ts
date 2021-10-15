import { Injectable } from '@angular/core';
import {CarType} from "../model/car-type";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CarTypeService {
  private api_url = "http://localhost:8080/carType";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<CarType[] | any> {
    return this.httpClient.get(this.api_url);
  }
}
