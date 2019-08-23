import { Component, OnInit, Output, ViewChild, ElementRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { QuestionService } from 'src/app/services/questionService.service';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';
import { Content } from '@angular/compiler/src/render3/r3_ast';

@Component({
  selector: 'app-editmodal',
  templateUrl: './editmodal.component.html',
  styleUrls: ['./editmodal.component.css']
})
export class EditmodalComponent implements OnInit {
  closeResult: string;
modalRef:any;
editquestion:FormGroup;
questionobj;

@ViewChild('content',{static:false})Modalcontent:ElementRef;

   
  constructor(private modalService: NgbModal,private questionservice:QuestionService,private fb:FormBuilder) {
    
  }

  open(content) {
   this.modalRef= this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
   this.modalRef.result.then((result) => {
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

  show(questionedit:any)
  {this.questionobj=questionedit;
    console.log(this.questionobj);
    if(this.modalRef)
    {
      this.modalRef.close();
    
    }//this.editquestion.reset();
    this.open(this.Modalcontent);
    this.initializeform(this.questionobj);
 }

  ngOnInit() {
  }
initializeform(questionobj:any)
{
  this.editquestion=this.fb.group({
    questionId:questionobj.questionId,
      questionTag:questionobj.questionTag,
      questionTypeId:questionobj.questionTypeId,
    questionText:new FormControl(questionobj.questionText, Validators.compose([
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(14),
      Validators.pattern('^[a-zA-Z0-9]+$')
    ])),
    optionA: [questionobj.optionA, [Validators.required]],
 optionB: [questionobj.optionB, [Validators.required]],
 optionC: [questionobj.optionC, [Validators.required]],
 optionD: [questionobj.optionD, [Validators.required]],
 answerKey:[questionobj.answerKey, [Validators.required]],
 questionMark: [questionobj.questionMark, [Validators.required]]
 });

}

get values() {
 return this.editquestion.value;
}

get questionTag()
{
  return this.editquestion.get('questionTag');
}
get questionId()
{
  return this.editquestion.get('questionId');
}
get questionTypeId()
{
  return this.editquestion.get('questionTypeId');
}
get questionText() {
 return this.editquestion.get('questionText');
}
get optionA()
{
 return this.editquestion.get('optionA');
}
get optionB()
{
 return this.editquestion.get('optionB');
}
get optionC()
{
 return this.editquestion.get('optionC');
}
get optionD()
{
 return this.editquestion.get('optionD');
}

get answerKey() {
// console.log(this.answerKey);
 return this.editquestion.get('answerKey').value   ;
}
get questionMark() {
 return this.editquestion.get('questionMark');
}

formSubmit() {
  //this.modalRef.close();
 console.log(this.values);
 this.questionservice.editquestion(this.values)
 .subscribe((response:any)=>
   {console.log("success");
     this.questionservice.display(1);
   }
 );
 this.modalRef.close();
 

 

}

 }   
 