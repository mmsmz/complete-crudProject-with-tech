import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminCourseComponent } from './admin-course/admin-course.component';
import { AdminUsersCourseComponent } from './admin-users-course/admin-users-course.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';

const routes: Routes = [
  { path: '', children :[ 
    { path : '', redirectTo : 'admin-users', pathMatch : 'full' },
    { path : 'admin-users', component : AdminUsersComponent },
    { path : 'admin-course', component : AdminCourseComponent },
    { path : 'admin-users-course', component : AdminUsersCourseComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule { }
