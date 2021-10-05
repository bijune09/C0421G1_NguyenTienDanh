import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

function comparePassword(check: AbstractControl) {
  const value = check.value;
  return (value.password === value.confirmPassword) ? null : {
    passwordNotMatch: true
  };
}
@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})


export class RegisterFormComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl ('', [Validators.required, Validators.email]),
      passwordGroup: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
      }, {validators: comparePassword}),
      country: new FormControl('', Validators.required),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', Validators.required),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)])
    });
  }

  countryList = [
    {id: 1, name: 'Viet Nam'},
    {id: 2, name: 'Canada'},
    {id: 3, name: 'USA'},
  ];

  // registerForm = new FormGroup({
  //
  // })

  onSubmit(){
    console.log(this.registerForm.value);
  }

}
