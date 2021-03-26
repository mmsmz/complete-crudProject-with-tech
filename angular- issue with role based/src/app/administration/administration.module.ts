import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationRoutingModule } from './administration-routing.module';
import { AdminCourseComponent } from './admin-course/admin-course.component';
import { AdminUsersComponent } from './admin-users/admin-users.component';
import { AdminUsersCourseComponent } from './admin-users-course/admin-users-course.component';
import { AppComponent } from '../app.component';


@NgModule({
  declarations: [AdminCourseComponent, AdminUsersComponent, AdminUsersCourseComponent],
  imports: [
    CommonModule,
    AdministrationRoutingModule
  ],
  bootstrap: [AppComponent]
})
export class AdministrationModule { }
