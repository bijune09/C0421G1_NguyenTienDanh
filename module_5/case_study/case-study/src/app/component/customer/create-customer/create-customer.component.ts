import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../customer-type';
import {CustomerService} from '../../../service/customer.service';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {Customer} from '../customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer: Customer;
  customerTypeList: CustomerType[];

  createForm: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
    this.getTypeList();
    this.createForm = new FormGroup({
      code: new FormControl('', [Validators.required, Validators.pattern(/^KH-[0-9]{4}$/)]),
      name: new FormControl('', [Validators.required, Validators.minLength(5)]),
      gender: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required, Validators.pattern(/^([0-9]{9}|[0-9]{12})$/)]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^(090|091|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/)]),
      customerType: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required])
    });
  }

  getTypeList() {
    this.customerTypeService.findAll().subscribe(items => {
      this.customerTypeList = items;
    });
  }

  ngOnInit(): void {

  }

  submit() {
    const value = this.createForm.value;
    console.log(value);
    this.customerService.createCustomer(value).subscribe(() =>{
      this.router.navigateByUrl("customers");
    });
  }
}
