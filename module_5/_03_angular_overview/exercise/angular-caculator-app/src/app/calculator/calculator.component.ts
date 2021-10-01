import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  numberA: number = 0;
  numberB: number = 0;
  result: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  plus(){
    return this.result = this.numberA +this.numberB;
  }
  minus(){
    return this.result = this.numberA -this.numberB;
  }

  multiple() {
    return this.result = this.numberA*this.numberB;
  }

  div() {
    if (this.numberB != 0){
      return this.result = this.numberA/this.numberB;
    } else {
      throw new Error("Can't not divided by 0");
    }
  }
}
