import { Component, OnInit } from '@angular/core';
import {Todo} from '../todo';
import {FormControl} from '@angular/forms';

let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  toDos: Todo[] = [];

  content = new FormControl();



  constructor() { }

  ngOnInit(): void {
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      }
      this.toDos.push(todo);
      this.content.reset();
    }
  }

  toggleTodo(i: number) {
    this.toDos[i].complete = !this.toDos[i].complete;
  }
}
