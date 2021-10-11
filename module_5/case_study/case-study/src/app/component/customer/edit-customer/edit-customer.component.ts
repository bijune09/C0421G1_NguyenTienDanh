import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../customer';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {CustomerType} from '../customer-type';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer: Customer;
  id: number;
  customerTypeList: CustomerType[];

  validationMessage = {
    code: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: '(KH-XXXX) x is number'},
    ],
    name: [
      {type : 'required', message: 'Not null'},
      {type : 'minlength', message: 'length must be greater than 5'},
    ],
    gender: [
      {type: 'required', message: 'Not null'},
    ],
    idCard: [
      {type: 'required', message: 'Not null'},
      {type: 'pattern', message: 'Invalid, id card must contain 9 or 12 number'},
    ],
    phone: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: 'Invalid, 090xxxxxxx or 091xxxxxxx'},
    ],
    customerType: [
      {type : 'required', message: 'Not null'},
    ],
    birthday: [
      {type : 'required', message: 'Not null'},
      {type : 'pattern', message: 'invalid'},
    ],
    email: [
      {type : 'required', message: 'Not null'},
      {type : 'email', message: 'invalid'},
    ],
    address: [
      {type : 'required', message: 'Not null'},
    ],
  };

  editForm = new FormGroup({
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

  constructor(private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private type: CustomerTypeService
  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getTypeList();
    });
  }

  ngOnInit(): void {

  }

  getTypeList() {
    this.type.findAll().subscribe(list => {
      this.customerTypeList = list;
      console.log(list);
      this.getCustomer(this.id);
    });
  }

  getCustomer(index: number) {
    return this.customerService.findById(index).subscribe(item => {
      this.customer = item;
      this.editForm.setValue(item);
    });
  }

  update(index: number) {
    const value = this.editForm.value;
    console.log(value);
    this.customerService.update(index, value).subscribe(() => {
      this.router.navigateByUrl('customers');
    });
  }
}
