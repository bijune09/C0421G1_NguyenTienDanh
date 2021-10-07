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
  editForm: FormGroup;
  id: number;
  customerTypeList: CustomerType[];

  constructor(private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private type: CustomerTypeService
              ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      console.log(this.id);
      this.getCustomer(this.id);
      this.getTypeList();
    });
  }

  ngOnInit(): void {
  }

  getTypeList(){
    this.type.findAll().subscribe(list => {
      this.customerTypeList = list;
    })
  }

  getCustomer(index: number) {
    return this.customerService.findById(index).subscribe(item => {
      this.customer = item;
      this.editForm = new FormGroup({
        code: new FormControl(this.customer.code, [Validators.required, Validators.pattern(/^KH-[0-9]{4}$/)]),
        name: new FormControl(this.customer.name, [Validators.required, Validators.minLength(5)]),
        gender: new FormControl(this.customer.gender, [Validators.required]),
        idCard: new FormControl(this.customer.idCard, [Validators.required, Validators.pattern(/^([0-9]{9}|[0-9]{12})$/)]),
        phone: new FormControl(this.customer.phone, [Validators.required, Validators.pattern(/^(090|091|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/)]),
        customerType: new FormControl(this.customer.customerType, [Validators.required]),
        birthday: new FormControl(this.customer.birthday, [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]),
        email: new FormControl(this.customer.email, [Validators.required, Validators.email]),
        address: new FormControl(this.customer.address, [Validators.required, Validators.minLength(5)])
      });
    });
  }

  update(index: number) {
    const value = this.editForm.value;
    this.customerService.update(index,value).subscribe( () =>{
      this.router.navigateByUrl("customers");
    })
  }
}
