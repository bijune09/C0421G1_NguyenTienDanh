import {CarType} from "./car-type";
import {Station} from "./station";

export interface Car {
  id: number,
  code: string,
  carType: CarType,
  station: Station,
  startPoint: string,
  destination: string,
  phone: string,
  email: string,
  startTime:string,
  endTime: string
}
