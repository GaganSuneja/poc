import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginSignupService } from '../services/LoginSignupService.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private route:Router,private rest:LoginSignupService,private formBuilder:FormBuilder ) { }
  form;
  userRegForm:FormGroup;
obj:any = {
  "userName":'',
    "firstName":'',
  "lastName":'',
"userPassword":'',
  "email":''
};

  ngOnInit() {
    this. initializeForm();


  //   this.form=new FormGroup({
  //     user: new FormControl("", Validators.required),
  //     pass: new FormControl("", Validators.required),
  //     email: new FormControl("", Validators.required),
  //     first: new FormControl("", Validators.required),
  //     last: new FormControl("", Validators.required)
  // })
}


  // onSubmit(myform)
  // {this.obj.userName=myform.user;
  //   this.obj.firstName=myform.first;
  //   this.obj.lastName=myform.last;
  //   this.obj.email=myform.email;
  //   this.obj.userPassword=myform.pass;
  //  // this.rest.update(this.obj)
  //   //.subscribe(response=>console.log(response),
  //   //error=>console.log(error));
  // }

  // onpress()
  // {
  //   this.route.navigate(['../']);
  // }

  initializeForm() {
    this.userRegForm = this.formBuilder.group({
      user: ['', [Validators.required, Validators.minLength(4)]],
      first:['', [Validators.required, Validators.minLength(4)]],
      last:['', [Validators.required, Validators.minLength(4)]],
      password:  new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(14),
        Validators.pattern('^[a-zA-Z0-9]+$')
      ])),
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
      ]))
    });
  }

  get values() {
    return this.userRegForm.value;
  }
  get first()
  {
    return this.userRegForm.get('first');
  }
  get last()
  {
    return this.userRegForm.get('last');
  }

  get user() {
    return this.userRegForm.get('user');
  }
  get email() {
    return this.userRegForm.get('email');
  }
  get password() {
    return this.userRegForm.get('password');
  }

  formSubmit() {
    console.log(this.values);
  }
}
