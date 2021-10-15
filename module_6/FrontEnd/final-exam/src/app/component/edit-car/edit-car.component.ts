import {Component, OnInit} from '@angular/core';
import {Car} from "../../model/car";
import {CarType} from "../../model/car-type";
import {Station} from "../../model/station";
import {CarService} from "../../service/car.service";
import {CarTypeService} from "../../service/car-type.service";
import {StationService} from "../../service/station.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import { FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-car',
  templateUrl: './edit-car.component.html',
  styleUrls: ['./edit-car.component.css']
})
export class EditCarComponent implements OnInit {

  car: Car;
  id: number;
  carTypeList: CarType[];
  stationList: Station[];

  validationMessage = {
    carType: [
      {type : 'required', message: 'Bạn phải chọn loại xe.'},
    ],
    station: [
      {type: 'required', message: 'Bạn phải chọn nhà xe.'},
    ],
    startPoint: [
      {type: 'required', message: 'Bạn phải nhập điểm xuất phát.'},
    ],
    destination: [
      {type : 'required', message: 'Bạn phải nhập điểm kết thúc.'},
    ],
    phone: [
      {type : 'required', message: 'Bạn phải nhập số điện thoại.'},
      {type : 'pattern', message: 'Số điện thoại chưa đúng định dạng.\n Ex: 090xxxxxxx hoặc 093xxxxxxx.'},
    ],

    email: [
      {type : 'required', message: 'Bạn không được để trống email.'},
      {type : 'email', message: 'Email không hợp lệ.'},
    ],
    startTime: [
      {type : 'required', message: 'Bạn phải nhập giờ đi.'},
      {type : 'invalidTime', message: 'Giờ đi sai rùi.'},
    ],
    endTime: [
      {type : 'required', message: 'Bạn phải nhập giờ đến.'},
    ],
  };

  editForm = new FormGroup({
    id: new FormControl(''),
    code: new FormControl(''),
    carType: new FormControl('',Validators.required),
    station: new FormControl('',Validators.required),
    startPoint: new FormControl('',Validators.required),
    destination: new FormControl('',Validators.required),
    phone: new FormControl('',[Validators.required,Validators.pattern(/^(090|093|097)[0-9]{7}$/)]),
    email: new FormControl('',[Validators.required,Validators.email]),
    startTime: new FormControl('',Validators.required),
    endTime: new FormControl('',Validators.required)
  });


  constructor(private carService: CarService,
              private carTypeService: CarTypeService,
              private stationService: StationService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getStation();
    })
  }

  getCar(index: number){
    return this.carService.findById(index).subscribe( item => {
      this.car = item;
      this.editForm.setValue(item)
    })
  }

  getCarType(){
    return this.carTypeService.findAll().subscribe( list => {
      this.carTypeList = list;
    })
  }

  getStation(){
    return this.stationService.findAll().subscribe( list => {
      this.stationList = list;
      this.getCarType();
      this.getCar(this.id);
    })
  }


  update(index : number){
    const value = this.editForm.value;
    console.log(value);
    if (this.editForm.valid){
      this.carService.update(index,value).subscribe( () => {
        this.router.navigateByUrl("car");
        alert("Cập nhật thành công!!");
      })
    } else {
      alert("Form của bạn đang sai vui lòng kiểm tra lại!");
    }
  }
}
