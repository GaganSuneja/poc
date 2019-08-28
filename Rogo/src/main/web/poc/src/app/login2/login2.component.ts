import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RestService } from '../restservice.service';

@Component({
  selector: 'app-login2',
  templateUrl: './login2.component.html',
  styleUrls: ['./login2.component.css']
})
export class Login2Component implements OnInit {

  constructor(private route:Router,private rest:RestService) { }
form;
obj:any = {
'username':'',
'password':''
};

  ngOnInit() {
    this.form=new FormGroup({
      user: new FormControl("", Validators.required),
      pass: new FormControl("", Validators.required),
      role: new FormControl("", Validators.required)
  })
}

  onSubmit(myform)
  {
    if(myform.role=="Admin")
  {
    this.obj.username=myform.user;
    this.obj.password=myform.pass;
    this.rest.send(this.obj)
    .subscribe((response:any)=>
    {if(response.json().success==true)
      {
        this.route.navigate(['adminpage']);
      }

    }
    );
  }
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

