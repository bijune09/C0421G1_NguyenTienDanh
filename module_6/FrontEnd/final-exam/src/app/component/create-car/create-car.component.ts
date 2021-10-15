import {Component, OnInit} from '@angular/core';
import {Car} from "../../model/car";
import {CarType} from "../../model/car-type";
import {Station} from "../../model/station";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CarService} from "../../service/car.service";
import {CarTypeService} from "../../service/car-type.service";
import {StationService} from "../../service/station.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {

  car: Car;
  id: number;
  carTypeList: CarType[];
  stationList: Station[];

  validationMessage = {
    carType: [
      {type: 'required', message: 'Bạn phải chọn loại xe.'},
    ],
    station: [
      {type: 'required', message: 'Bạn phải chọn nhà xe.'},
    ],
    startPoint: [
      {type: 'required', message: 'Bạn phải nhập điểm xuất phát.'},
    ],
    destination: [
      {type: 'required', message: 'Bạn phải nhập điểm kết thúc.'},
    ],
    phone: [
      {type: 'required', message: 'Bạn phải nhập số điện thoại.'},
      {type: 'pattern', message: 'Số điện thoại chưa đúng định dạng.\n Ex: 090xxxxxxx hoặc 093xxxxxxx.'},
    ],

    email: [
      {type: 'required', message: 'Bạn không được để trống email.'},
      {type: 'email', message: 'Email không hợp lệ.'},
    ],
    startTime: [
      {type: 'required', message: 'Bạn phải nhập giờ đi.'},
      {type: 'invalidTime', message: 'Giờ đi sai rùi.'},
    ],
    endTime: [
      {type: 'required', message: 'Bạn phải nhập giờ đến.'},
    ],
  };

  createForm: FormGroup;

  constructor(private carService: CarService,
              private carTypeService: CarTypeService,
              private stationService: StationService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getStation();
    this.createForm = new FormGroup({
      code: new FormControl(''),
      carType: new FormControl('', Validators.required),
      station: new FormControl('', Validators.required),
      startPoint: new FormControl('', Validators.required),
      destination: new FormControl('', Validators.required),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^(090|093|097)[0-9]{7}$/)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      startTime: new FormControl('', Validators.required),
      endTime: new FormControl('', Validators.required)
    });
  }


  getCarType() {
    return this.carTypeService.findAll().subscribe(list => {
      this.carTypeList = list;
    })
  }

  getStation() {
    return this.stationService.findAll().subscribe(list => {
      this.stationList = list;
      this.getCarType();
    })
  }

  create() {
    const value = this.createForm.value;
    console.log(value);
    if (this.createForm.valid) {
      this.carService.create(value).subscribe(() => {
        this.router.navigateByUrl("car");
      })
    } else {
      alert("Form của bạn đang sai vui lòng kiểm tra lại!");
    }
  }
}
