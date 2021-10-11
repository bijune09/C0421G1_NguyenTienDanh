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
  searchName: any;
  page:number = 1;

  // customer: Customer[];

  constructor(private customerService: CustomerService) {
    this.customerService.findAll().subscribe(list => {
      this.customerList = list;
    });
  }

  search(){
    if (this.searchName == ""){
      this.getAll();
    } else {
      this.customerList = this.customerList.filter( items => {
        return items.name.toLocaleLowerCase().match(this.searchName.toLocaleLowerCase());
      })
    }
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

  key:string = 'id';
  reverse: boolean = true;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
