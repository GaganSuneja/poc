import { Component, OnInit } from '@angular/core';
import { MCQquestion } from '../questions.model';

@Component({
  selector: 'app-mcquestions',
  templateUrl: './mcquestions.component.html',
  styleUrls: ['./mcquestions.component.css']
})
export class McquestionsComponent implements OnInit {
quest:MCQquestion[];
  constructor() { }

  ngOnInit() {
    this.quest=[new MCQquestion("What is angular?",['a','b','c','d'],1),
    new MCQquestion("What is angular2?",['a','b','c','d'],1),
    new MCQquestion("What is angular3?",['a','b','c','d'],2)
  ]
  console.log(this.quest);
  }

}
