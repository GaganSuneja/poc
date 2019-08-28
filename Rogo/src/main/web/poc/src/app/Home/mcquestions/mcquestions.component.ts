import { Component, OnInit, Input, OnChanges, SimpleChanges, ViewChild } from '@angular/core';
import { QuestionService } from 'src/app/Home/questionService.service';
import { RouterOutlet, Router } from '@angular/router';
import { EditmodalComponent } from '../editmodal/editmodal.component';
import { DeletemodalComponent } from '../deletemodal/deletemodal.component';


@Component({
  selector: 'app-mcquestions',
  templateUrl: './mcquestions.component.html',
  styleUrls: ['./mcquestions.component.css']
})
export class McquestionsComponent implements OnInit, OnChanges {
@Input() qType;
@ViewChild('edit',{static:false})edit: EditmodalComponent;
@ViewChild('delete',{static:false})delete:DeletemodalComponent;
filteredquestions;
getquestion;

allQuestions = [];
  
  constructor(private route:Router,private questionservice:QuestionService) { }

  ngOnInit() {
    this.questionservice.display(1);
    this.questionservice.question$.subscribe(questions => {
      console.log('api called >>>>>>>>>>>>>>>> ' + questions);
      this.allQuestions = questions || [];
      this.displayQuestions();
    })  
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    console.log('ng on changes');
    if (changes.qType) {
    this.displayQuestions();
    }
  }

  displayQuestions() {
  if (this.allQuestions.length > 0 ) {
      let sortquestion= this.allQuestions.filter((q) => q.questionTag.toLowerCase()== this.qType.toLowerCase());
      this.filteredquestions=sortquestion.sort((obj1,obj2)=>{if(obj1.questionId>obj2.questionId){
        return 1;
      }
      if(obj1.questionId<obj2.questionId)
      {
        return -1;
      }
      return 0;
    });
      console.log('filtered questions' + this.filteredquestions);
    }
  }

  openeditquestion(id:number)
  {this.getquestion=this.allQuestions.find((q) => q.questionId==id)
    console.log(this.getquestion)
    this.edit.show(this.getquestion);
  }

  opendeletequestion(TypeId:number,id:number)
  {this.getquestion=this.allQuestions.filter((q)=>q.questionTypeId==TypeId);
    this.getquestion=this.getquestion.find((q) => q.questionId==id)
        console.log(this.getquestion)
    this.delete.show(this.getquestion);
  }

}
