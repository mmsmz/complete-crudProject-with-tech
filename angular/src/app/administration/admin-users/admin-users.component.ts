import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {

  getLocatStorageItem: any;
  adminMenu:boolean =false;
  userMenu:boolean =false;

  constructor() { }

  ngOnInit(): void {
    this.getLocatStorageItem = localStorage.getItem('LoggedInUser');
    debugger
    if(this.getLocatStorageItem == "admin" ){
        this.adminMenu = true;
        this.userMenu = false;
    }
  }

}
