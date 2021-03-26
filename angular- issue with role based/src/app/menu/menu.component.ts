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
  getLocatStorageItem: any;
  adminMenu:boolean =false;
  userMenu:boolean =false;


  constructor(private router: Router,
    private authenticationService: AppService ) { }

  ngOnInit() {
    // this.checkingUserLogin();
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu ->' + this.isLoggedIn);
    
    this.getLocatStorageItem = localStorage.getItem('LoggedInUser');
  }

  handleLogout() {
    this.authenticationService.logout();
    
    // this.router.navigateByUrl('/login');
  }

  // checkingUserLogin(){
  //   this.getLocatStorageItem = localStorage.getItem('LoggedInUser');
  //   debugger
  //   if(this.getLocatStorageItem == "admin" ){
      
  //       this.adminMenu = true;
  //       this.userMenu = false;
  //   }
  //   else if(this.getLocatStorageItem == "user" ){
  //     this.adminMenu =false;
  //     this.userMenu = true;
  //   }
  // }

  handleAdminStudent(){
      this.router.navigateByUrl('/admin-users');
  }
  handleAdminCourse() {

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