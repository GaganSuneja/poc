import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {LoginSignupService} from '../LoginSignupService.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class loginComponent implements OnInit {

  constructor(private route:Router,private rest:LoginSignupService) { }
form;
obj:any = {
'username':'',
'password':''
};

  ngOnInit() {
    this.form=new FormGroup({
      user: new FormControl("should not be null", Validators.required),
      pass: new FormControl("", [Validators.required,Validators.minLength(8),Validators.maxLength(16)]),
  })
}

  onSubmit(myform)
  {
   
    this.obj.username=myform.user;
    this.obj.password=myform.pass;
    this.rest.send(this.obj)
    .subscribe((response:any)=>
    {if(response.json().success==true)
      {
        this.route.navigate(['Home']);
      }

    }
    );
  }

   
 


  //   {
  //   if(myform.pass=="admin"&& myform.user=="ADMIN")
  //   {console.log("ADMIN successfully logged in");
  //   this.route.navigate(['head'])
  // }
 // }
  // if(myform.role=="User")
  //  { if(myform.pass=="user"&& myform.user=="user")
  //  {console.log("user successfully logged in");
  //  this.route.navigate(['head'])
  // }
  Navig()
  {
    this.route.navigate(['signup']);
  }

}


