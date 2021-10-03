import {CustomerType} from './customer-type';

export interface Customer {
  id: number;
  code: string;
  customerType: CustomerType;
  name: string;
  birthday: string;
  gender: string;
  idCard: string;
  phone: string;
  email: string;
  address: string
}
