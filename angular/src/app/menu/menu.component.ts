import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isLoggedIn = false;

  constructor(private router: Router,
    private authenticationService: AppService) { }

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
  }

  handleLogout() {
    this.authenticationService.logout();
    // this.router.navigateByUrl('/login');
  }

  handleCourse(){
    this.router.navigateByUrl('/course');
  }
  
  handleStudent(){
    this.router.navigateByUrl('/user');
  }
  
  handleStudentCourseDetails(){
    this.router.navigateByUrl('/usercoursedetails');
  }
}