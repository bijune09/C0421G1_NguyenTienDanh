import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../component/customer/customer';
import {CustomerType} from '../component/customer/customer-type';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private api_url = 'http://localhost:3000/customerType';

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<CustomerType[] | any> {
    return this.http.get(this.api_url);
  }
}
