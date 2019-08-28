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
        return this.http.post<any>("http://10.10.30.38:7089/question/",obj);
    }
    async display(typeId:any)
    {
        console.log('display api');
        const response = await this.http.get<any>("http://10.10.30.38:7089/question/"+typeId).toPromise();
        this.question$.next(response.data ? response.data.questions : []);

    }
    editquestion(obj:any):Observable<any>
    {
        return this.http.put<any>("http://10.10.30.38:7089/question/",obj);
    }
    deletequestion(TypeId:any,id:any):Observable<any>
    {
        return this.http.delete<any>("http://10.10.30.38:7089/question/"+TypeId+"/"+id);
    }

}