import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) { }
  
  getAllCourses(){
      return this.http.get("http://localhost:8070/homeService/getAllCourseDetails").pipe(
      map((res:any)=> res));
  }

  getAllImageLocation(){
    return this.http.get("http://localhost:8070/homeService/getAllImageLocation").pipe(
    map((res:any)=> res));
  }
}
