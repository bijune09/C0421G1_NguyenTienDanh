import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {IWord} from '../i-word';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionaryList: IWord[];

  constructor(private dictionaryService : DictionaryServiceService) {
    this.dictionaryList = this.dictionaryService.getAll();
  }

  ngOnInit(): void {
  }

}
