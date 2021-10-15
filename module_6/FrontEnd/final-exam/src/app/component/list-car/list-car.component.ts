import {Component, OnInit} from '@angular/core';
import {CarService} from "../../service/car.service";
import {Car} from "../../model/car";

@Component({
  selector: 'app-list-car',
  templateUrl: './list-car.component.html',
  styleUrls: ['./list-car.component.css']
})
export class ListCarComponent implements OnInit {
  carList: Car[];
  stringName: String;
  delId: number;

  currentPage: number = 0;
  loading: boolean;

  constructor(private carService: CarService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.carService.findAll(this.currentPage).subscribe(list => {
      console.log(list);
      this.carList = list.content;
    })
  }

  nextPage() {
    this.currentPage++;
    this.getAll();
  }

  previousPage() {
    console.log(this.currentPage);
    if (this.currentPage > 0) {
      this.currentPage--;
      this.getAll();
    }
  }

  sendId(id: number) {
    this.carService.findById(id).subscribe(item => {
      console.log(id);
      this.stringName = item.code;
      this.delId = item.id;
      console.log(item);
    });
  }

  deleteCar(deleteId: number) {
    this.carService.delete(deleteId).subscribe(() => {
      alert("Xoá thành công!");
      this.ngOnInit();
    })
  }
}
