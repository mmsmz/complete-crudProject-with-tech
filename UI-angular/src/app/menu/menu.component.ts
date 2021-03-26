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
  dashboardMenu: boolean = false;
  signup : boolean = false;

  constructor(private router: Router,
    private authenticationService: AppService ) { }


  ngOnInit(): void {
    this.checkingUserLogin();
    this.getLocatStorageItem = localStorage.getItem('LoggedInUser');
  }

  checkingUserLogin(){
    this.getLocatStorageItem = localStorage.getItem('LoggedInUser');
    debugger
    if(this.getLocatStorageItem == "admin" ){
      
        this.adminMenu = true;
        this.userMenu = false;
        this.dashboardMenu = true;
    }
    else if(this.getLocatStorageItem == "user" ){
      this.adminMenu =false;
      this.userMenu = true;
      this.dashboardMenu = true;
      this.signup  = false;
    }
    else  {
      this.adminMenu =false;
      this.userMenu = false;
      this.dashboardMenu = true;
      this.signup  = true;
    }
    
  }

  handleLogout() {
    this.authenticationService.logout();    
    // this.router.navigateByUrl('/login');
  }
}
