import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  
  constructor(private http: HttpClient) { }
  
  addCourse(data){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8087/addCourse",data, {headers}).pipe(
      map((res:any)=> res)); 
  }

  updateCourse(data){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8087/updateCourse",data,{headers}).pipe(
      map((res:any)=> res));
  }

  getAllCourses(){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.get("http://localhost:8087/getAllCourses",{headers}).pipe(
      map((res:any)=> res));
  }

  getCourseById(data){
   let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
   const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.get("http://localhost:8087/getCourseById?courseId="+data.courseId, {headers}).pipe(
      map((res:any)=> res));
  }

  deleteCourse(courseDetails){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8087/deleteCourse",courseDetails,{headers}).pipe(
      map((res:any)=> res));
  }


}
