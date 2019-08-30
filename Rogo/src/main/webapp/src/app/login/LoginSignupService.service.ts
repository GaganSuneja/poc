import {Headers,Http} from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class LoginSignupService{
constructor(private http:Http)
{    
}

send(obj:any):Observable<any>
{const headers=new Headers({'Content-Type':'application/json'});
    return this.http.post("/api/user",obj,{headers:headers});
}

update(obj:any):Observable<any>
{
    const headers=new Headers({'Content-Type':'application/json'});
    return this.http.put("/api/signup",obj,{headers:headers});
}
}