import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { AppService } from '../app.service';

@Injectable({
  providedIn: 'root'
})
export class UsercoursedetailsService {

  constructor(private http : HttpClient, private appService :AppService) {
    debugger
   }

  addUser(data){
    debugger;
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8087/addStudentCourse",data , {headers}).pipe(
      map((res:any)=> res));
  }

  updateUser(data){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.put("http://localhost:8087/updateStudentCourse",data,{headers}).pipe(
      map((res:any)=> res));
  }

  getUserById(data){
   let username = localStorage.getItem('username');
   let password = localStorage.getItem('password');
   const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
   return this.http.get("http://localhost:8087/getCourseListByStudentId?studentID="+data.userId, {headers}).pipe(
   map((res:any)=> res));
  }

  deleteUser(userDeatails){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8087/deleteStudentCourse",userDeatails,{headers}).pipe(
      map((res:any)=> res));
  }
}
