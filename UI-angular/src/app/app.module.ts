import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './student/user/user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManageCourseComponent } from './administration/manage-course/manage-course.component';
import { ManageUserCourseComponent } from './administration/manage-user-course/manage-user-course.component';
import { ManageUserComponent } from './administration/manage-user/manage-user.component';
import { SignupComponent } from './student/signup/signup.component';
import { CourseComponent } from './student/course/course.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    UserComponent,
    DashboardComponent,
    ManageCourseComponent,
    ManageUserCourseComponent,
    ManageUserComponent,
    SignupComponent,
    CourseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
