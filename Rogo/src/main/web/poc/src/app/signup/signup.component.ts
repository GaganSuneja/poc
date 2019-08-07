import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RestService } from '../restservice.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private route:Router,private rest:RestService ) { }
  form;
obj:any = {
  "userName":'',
    "firstName":'',
  "lastName":'',
"userPassword":'',
  "email":''
};

  ngOnInit() {
    this.form=new FormGroup({
      user: new FormControl("", Validators.required),
      pass: new FormControl("", Validators.required),
      email: new FormControl("", Validators.required),
      first: new FormControl("", Validators.required),
      last: new FormControl("", Validators.required)
  })
}

  onSubmit(myform)
  {this.obj.userName=myform.user;
    this.obj.firstName=myform.first;
    this.obj.lastName=myform.last;
    this.obj.email=myform.email;
    this.obj.userPassword=myform.pass;
    this.rest.update(this.obj)
    .subscribe(response=>console.log(response),
    error=>console.log(error));
  }

  onpress()
  {
    this.route.navigate(['../']);
  }
}
