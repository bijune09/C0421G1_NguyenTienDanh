import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../component/customer/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private customer_url_api = 'http://localhost:3000/customers';

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Customer[] | any> {
    return this.http.get(this.customer_url_api);
  }

  createCustomer(customer: Customer):Observable<any>{
    return this.http.post(this.customer_url_api,customer);
  }

  findById(id: number):Observable<Customer|any>{
    return this.http.get(this.customer_url_api+"/"+id);
  }

  delete(id: number):Observable<Customer|any>{
    return this.http.delete(this.customer_url_api+"/"+id);
  }

  update(id:number,customer: Customer):Observable<Customer|any>{
    return this.http.put(this.customer_url_api+"/"+id,customer);
  }
}
