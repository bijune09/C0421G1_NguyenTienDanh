import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Station} from "../model/station";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StationService {
  private api_url = "http://localhost:8080/station";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Station[] | any> {
    return this.httpClient.get(this.api_url);
  }
}
