import {Injectable} from '@angular/core';
import {IWord} from '../i-word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  dictionaryList: IWord[] = [
    {word: 'meow meow', mean: 'con mèo'},
    {word: 'gau gau', mean: 'con chó'},
    {word: 'wind', mean: 'hoàng tử gió'},
    {word: 'love', mean: 'leu leu may thang khong co bo'},
  ];

  constructor() {
  }

  getAll(){
    return this.dictionaryList
  }

  findByWord(stringWord: string) {
    for (let string of this.dictionaryList) {
      if (string.word == stringWord) {
        return string;
      }
    }
  }
}
