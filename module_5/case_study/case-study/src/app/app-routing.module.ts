import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListCustomerComponent} from './component/customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './component/customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './component/customer/edit-customer/edit-customer.component';
import {HomePageComponent} from './home-page/home-page.component';


const routes: Routes = [
  {
    path: "",
    component: HomePageComponent
  },
  {
    path: 'customers',
    component: ListCustomerComponent
  },
  {
    path: 'customers/create',
    component: CreateCustomerComponent
  },
  {
    path: 'customers/edit/:id',
    component: EditCustomerComponent,

  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
