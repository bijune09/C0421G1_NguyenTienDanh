import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {IWord} from '../i-word';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  comp: IWord| null;

  constructor(private dictionaryService: DictionaryServiceService,
              private activatedRoute: ActivatedRoute,) {
    this.activatedRoute.paramMap.subscribe((paramMap:ParamMap)=>{
      const mean = paramMap.get("mean");
      this.comp = this.dictionaryService.findByWord(mean);
    })
  }

  ngOnInit(): void {
  }

}
