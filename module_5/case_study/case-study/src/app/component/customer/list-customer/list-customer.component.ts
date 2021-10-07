import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {Customer} from '../customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerList: Customer[];
  stringName: string;
  delId: number;

  // customer: Customer[];

  constructor(private customerService: CustomerService) {
    this.customerService.findAll().subscribe(list => {
      this.customerList = list;
    });
  }

  ngOnInit(): void {
  }

  getAll() {
    this.customerService.findAll().subscribe(list => {
      this.customerList = list;
    });
  }

  sendId(id: any) {
    this.customerService.findById(id).subscribe(list => {
      this.stringName = list.name;
      this.delId = list.id;
    });
  }

  deleteCustomer(deleteId: any) {
    this.customerService.delete(deleteId).subscribe(() => this.getAll());
  }


}
