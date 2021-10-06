import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductEditComponent} from './product/product-edit/product-edit.component';


const routes: Routes = [
  // th1
  // {
  //   path: 'timelines',
  //   component: TimelinesComponent
  // }
  // th2
  // {
  //   path: 'youtube',
  //   component: YoutubePlaylistComponent,
  //   children:[{
  //     path: ':id',
  //     component: YoutubePlayerComponent
  //   }]
  // }
  // th3
  {
    path: 'product/list',
    component: ProductListComponent
  },
  {
    path: 'product/create',
    component: ProductCreateComponent
  },
  {
    path: 'product/edit/:id',
    component: ProductEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
