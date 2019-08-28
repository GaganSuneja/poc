import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { QuestionService } from 'src/app/Home/questionService.service';

@Component({
  selector: 'app-deletemodal',
  templateUrl: './deletemodal.component.html',
  styleUrls: ['./deletemodal.component.css']
})
export class DeletemodalComponent  {

  @ViewChild('content',{static:false})Modalcontent:ElementRef;
  closeResult: string;
  modalRef: any;
  questionobj;

   
  constructor(private modalService: NgbModal,private questionservice:QuestionService) {
    
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
 }


 confirmdelete()
 {this.questionservice.deletequestion(this.questionobj.questionTypeId,this.questionobj.questionId).subscribe((response:any)=>
  {
    {console.log("success");
      this.questionservice.display(1);
    }
   console.log('delted succesfully');

 });
 this.modalRef.close();
}
}

