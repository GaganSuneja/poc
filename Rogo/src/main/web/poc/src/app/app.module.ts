import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';  
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { loginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './Home/Home.component';
import { HttpModule } from '@angular/http';
import { UserComponent } from './user/user.component';

import { LoginSignupService } from './services/LoginSignupService.service';
import { McquestionsComponent } from './Home/mcquestions/mcquestions.component';
import { ModalComponent } from './modal/modal.component';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { QuestionService } from './services/questionService.service';
import { UserInterfaceComponent } from './user-interface/user-interface.component';
import { HttpClientModule } from '@angular/common/http';
import { EditmodalComponent } from './Home/editmodal/editmodal.component';
import { DeletemodalComponent } from './Home/deletemodal/deletemodal.component'; 


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    loginComponent,
    SignupComponent,
    HomeComponent,
    UserComponent,
    McquestionsComponent,
    ModalComponent,
    UserInterfaceComponent,
    EditmodalComponent,
    DeletemodalComponent,
    
    
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,FormsModule,
    ReactiveFormsModule,
    HttpModule,
    NgbModalModule,
    HttpClientModule
  ],
  providers: [LoginSignupService,QuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
