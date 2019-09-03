import { Headers } from '@angular/http';
import { Observable, BehaviorSubject } from 'rxjs';

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable()
export class QuestionService{
    
    question$ : any = new BehaviorSubject([]);

    constructor(private http: HttpClient)
    {

    }
    add(obj:any):Observable<any>
    {
        return this.http.post<any>("/api/question/",obj);
    }
    async display(typeId:any)
    {
        console.log('display api');
        const response = await this.http.get<any>("/api/question/"+typeId).toPromise();
        this.question$.next(response.data ? response.data.questions : []);

    }
    editquestion(obj:any):Observable<any>
    {
        return this.http.put<any>("/api/question/",obj);
    }
    deletequestion(TypeId:any,id:any):Observable<any>
    {
        return this.http.delete<any>("/api/question/"+TypeId+"/"+id);
    }

}
