import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { loginComponent } from './login/login.component';
import { HomeComponent } from './Home/Home.component';
import { UserComponent } from './user/user.component';


const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'signup',
    component:SignupComponent
  },{
    path:'head',
    component:HeaderComponent
  },
  {
    path:"login",
    component:loginComponent
  },
  {
    path:"User",
    component:UserComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
