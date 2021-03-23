import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UsercoursedetailsComponent } from './usercoursedetails/usercoursedetails.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserComponent } from './user/user.component';
import { CourseComponent } from './course/course.component';

const routes: Routes = [
  // {path: '', redirectTo: "login",pathMatch:"full"},
  {path: '', component:DashboardComponent },
  {path: 'dashboard', component:DashboardComponent },
  {path: 'login', component:LoginComponent },
  {path: 'user', component:UserComponent },
  {path: 'course', component:CourseComponent },
  {path: 'usercoursedetails', component:UsercoursedetailsComponent}
  // {path: 'admin-home', component: AdminHomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
