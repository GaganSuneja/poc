import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { Login2Component } from './login2/login2.component';
import { AdminpageComponent } from './adminpage/adminpage.component';


const routes: Routes = [
  {
    path:'adminpage',
    component:AdminpageComponent
  },
  {
    path:'signup',
    component:SignupComponent
  },{
    path:'head',
    component:HeaderComponent
  },
  {
    path:"",
    component:Login2Component
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
