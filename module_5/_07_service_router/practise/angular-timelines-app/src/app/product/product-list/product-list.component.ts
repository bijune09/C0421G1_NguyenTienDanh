import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  nameProduct: string;
  deleteId: number;

  constructor(private productService: ProductService,
              private router : Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.products = this.productService.getAll();
  }


  sendId(id: number) {
    const product = this.productService.findById(id);
    this.nameProduct = product.name;
    this.deleteId = product.id
    console.log(product)
  }


  deleteProduct(deleteId: number) {
    console.log(deleteId);
    this.productService.deleteProduct(deleteId);
    this.products = this.productService.getAll();
  }
}
