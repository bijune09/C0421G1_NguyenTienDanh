import { Component, OnInit } from '@angular/core';
import {CustomerType} from '../customer-type';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  genderList: string[] = ["Nam","Nữ","LGBT"];

  customerTypeList: CustomerType[] = [
      {id: 1, name: "Diamond"},
      {id: 2, name: "Pearl"}
  ]



  constructor() { }

  ngOnInit(): void {

  }

}
