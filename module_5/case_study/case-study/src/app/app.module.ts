import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCustomerComponent } from './component/customer/create-customer/create-customer.component';
import { EditCustomerComponent } from './component/customer/edit-customer/edit-customer.component';
import { ListCustomerComponent } from './component/customer/list-customer/list-customer.component';
import { CreateEmployeeComponent } from './component/employee/create-employee/create-employee.component';
import { EditEmployeeComponent } from './component/employee/edit-employee/edit-employee.component';
import { ListEmployeeComponent } from './component/employee/list-employee/list-employee.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreateCustomerComponent,
    EditCustomerComponent,
    ListCustomerComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,
    ListEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
