import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

let width: number;

let height: number;

width = 10.5;

height = 20;

const area: number = width * height;

console.log(`Diện tích hình chữ nhật : ${area}`);
