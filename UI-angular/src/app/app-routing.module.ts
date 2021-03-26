import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ManageCourseComponent } from './administration/manage-course/manage-course.component';
import { ManageUserCourseComponent } from './administration/manage-user-course/manage-user-course.component';
import { ManageUserComponent } from './administration/manage-user/manage-user.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { CourseComponent } from './student/course/course.component';
import { SignupComponent } from './student/signup/signup.component';
import { UserComponent } from './student/user/user.component';

const routes: Routes = [ 
  { path: '', redirectTo: "dashboard",pathMatch:"full"},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'login', component: LoginComponent },
  { path: 'menu', component: MenuComponent },
  { path: 'user', component: UserComponent },
  { path: 'signup', component: SignupComponent},
  { path: 'course', component: CourseComponent},
  { path: 'manage-user', component: ManageUserComponent},
  { path: 'manage-course', component: ManageCourseComponent},
  { path: 'manage-user-course', component: ManageUserCourseComponent}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
