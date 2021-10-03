import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerType} from '../customer-type';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerTypeList: CustomerType[] = [
    {id: 1, name: "Diamond"},
    {id: 2, name: "Pearl"},
    ]

  customerList: Customer[] = [
    {id: 1,
  code: "KH-0001",
  customerType: this.customerTypeList[1],
  name: "Test 01",
  birthday: "01-01-1998",
  gender: "Female",
  idCard: "201777809",
  phone: "0932545644",
  email: "ndanh98@gmail.com",
  address: "Da Nang"}
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
