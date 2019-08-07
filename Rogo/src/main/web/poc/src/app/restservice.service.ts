import {Headers,Http} from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class RestService{
constructor(private http:Http)
{    
}

send(obj:any):Observable<any>
{const headers=new Headers({'Content-Type':'application/json'});
    return this.http.post("http://10.10.30.38:7089/login",obj,{headers:headers});
}

update(obj1:any):Observable<any>
{
    const headers=new Headers({'Content-Type':'application/json'});
    return this.http.put("http://10.10.30.38:7089/signup",obj1,{headers:headers});
}
}