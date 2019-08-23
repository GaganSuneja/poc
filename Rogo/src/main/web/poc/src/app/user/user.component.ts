import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../services/questionService.service';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';
import { Options } from 'selenium-webdriver/chrome';
import { ValueTransformer } from '@angular/compiler/src/util';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  obj:any;
  questionform: FormGroup;
  
  questionsArray: Array<{ questionId: number,
                    questionTypeId:number,
                    questionTag:"",
                    questionText:"",
                    optionA: "",
                    optionB: "",
                    optionC: "",
                    optionD: "",
                    answerKey:"",
                    questionMarks:number}> = [];
 





 constructor(private questionservice:QuestionService,private fb:FormBuilder) {
    this.initiateForm();
   }

  ngOnInit() {
    this.questionservice.display(1);
    this.questionservice.question$.subscribe(value => {
      this.obj = value;
    })
  }

  initiateForm()
  {this.questionform=this.fb.group(
   {  options:'',
      // questions:this.genquestionArray()
   } 
  )}

  // genquestionArray(): any {
  //   const objectArray=new FormArray([]);
  //   for(let i=0;i<this.obj.length;i++)
  //   {const optiongrp=new FormGroup({

  //   })

  //   }
  // }
    
  get options()
   {
     return this.questionform.get('options').value;
   }
  

  get values()
  {
    return this.questionform.value;
  }

  submit()
  {
    console.log(this.options);
  }
}







