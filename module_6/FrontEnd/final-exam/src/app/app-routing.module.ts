import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from "./home-page/home-page/home-page.component";
import {ListCarComponent} from "./component/list-car/list-car.component";
import {EditCarComponent} from "./component/edit-car/edit-car.component";
import {CreateCarComponent} from "./component/create-car/create-car.component";


const routes: Routes = [
  // {
  //   path: "",
  //   component: HomePageComponent
  // },
  {
    path: "car",
    component: ListCarComponent,
  }
  ,
  {
    path :"car/edit/:id",
    component: EditCarComponent
  },
  {
    path: "car/create",
    component:CreateCarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
