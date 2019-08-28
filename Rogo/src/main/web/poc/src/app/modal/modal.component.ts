<<<<<<< HEAD
import { Component, OnInit, Injectable } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
=======
import { Component, OnInit, Injectable, OnDestroy } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { QuestionService } from '../services/questionService.service';

>>>>>>> master

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
@Injectable({
  providedIn: "root"
})
<<<<<<< HEAD
export class ModalComponent  {
  closeResult: string;

  constructor(private modalService: NgbModal) {}

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
=======
export class ModalComponent implements OnInit  {
  closeResult: string;
 options:number[]=[];
  questionform: FormGroup;
  modalRef;
  
  
  


  constructor(private modalService: NgbModal,private questionservice:QuestionService,private fb:FormBuilder) {
   
    
  }

  open(content) {
    this.questionform.reset();
    this.modalRef=this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'})
    this.modalRef.result.then((result) => {
>>>>>>> master
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

<<<<<<< HEAD
}
=======

  ngOnInit() {
    this.initializeForm();
  }

  
  initializeForm()
  {this.questionform=this.fb.group({
    questionTypeId:['', [Validators.required]],
    questionTag: ['', [Validators.required]],
    questionText:new FormControl('', Validators.compose([
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(14),
      Validators.pattern('^[a-zA-Z0-9]+$')
    ])),
    optionA: ['', [Validators.required]],
    optionB: ['', [Validators.required]],
    optionC: ['', [Validators.required]],
    optionD: ['', [Validators.required]],
    answerKey:['', [Validators.required]],
    questionMark: ['', [Validators.required]]
    });
  
}

  get values() {
    return this.questionform.value;
  }

  get questionTypeId() {
    return this.questionform.get('questionTypeId').value;
  }
  get questionTag() {
    return this.questionform.get('questionTag');
  }
  get questionText() {
    return this.questionform.get('questionText');
  }
  get optionA()
  {
    return this.questionform.get('optionA');
  }
  get optionB()
  {
    return this.questionform.get('optionB');
  }
  get optionC()
  {
    return this.questionform.get('optionC');
  }
  get optionD()
  {
    return this.questionform.get('optionD');
  }

  get answerKey() {
 // console.log(this.answerKey);
    return this.questionform.get('answerKey').value   ;
  }
  get questionMark() {
    return this.questionform.get('questionMark');
  }

  formSubmit() {
   
    console.log(this.values);
    this.questionservice.add(this.values)
    .subscribe((response:any)=>
    {if(response.json().success==true)
      {console.log("success");
      
      }

    }
    );
    this.modalRef.close();
    

  }
  

  }
  // onsubmit(myform)
  // {
   
  //   this.obj.username=myform.user;
  //   this.obj.password=myform.pass;
  //   this.rest.send(this.obj)
  //   .subscribe((response:any)=>
  //   {if(response.json().success==true)
  //   console.log("success");  
  //   }
  //   );
  // }


>>>>>>> master
