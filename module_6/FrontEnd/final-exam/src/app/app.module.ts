import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page/home-page.component';
import { NavbarComponent } from './home-page/navbar/navbar.component';
import { FooterComponent } from './home-page/footer/footer.component';
import {HttpClientModule} from "@angular/common/http";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from "ngx-pagination";
import {Ng2OrderModule} from "ng2-order-pipe";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListCarComponent } from './component/list-car/list-car.component';
import { EditCarComponent } from './component/edit-car/edit-car.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CreateCarComponent } from './component/create-car/create-car.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    NavbarComponent,
    FooterComponent,
    ListCarComponent,
    EditCarComponent,
    CreateCarComponent,
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    Ng2OrderModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
