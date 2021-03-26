import { Component, OnInit } from '@angular/core';
import { DashboardService } from './dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  userTable:any = [];

  constructor(private dashBoard: DashboardService) {  }

  ngOnInit(): void {
    
    this.dashBoard.getAllCourses().subscribe(res=>{
      this.userTable = res.data;
    })

    this.dashBoard.getAllImageLocation().subscribe(res=>{
    })
    
  }

}
