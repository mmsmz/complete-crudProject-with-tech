import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { AppService } from '../app.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  addUser(data){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8072/userService/user/addUserDetails",data , {headers}).pipe(
      map((res:any)=> res));
  }

  updateUser(data){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.put("http://localhost:8072/userService/user/updateUser",data,{headers}).pipe(
      map((res:any)=> res));
  }

  getAlluser(){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.get("http://localhost:8072/userService/user/getAllUsers", {headers});
  }

  getUserById(data){
   let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
   const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.get("http://localhost:8072/userService/user/findByUserId?userId="+data.userId, {headers}).pipe(
      map((res:any)=> res));
  }


  deleteUser(userDeatails){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8072/userService/user/deleteUser",userDeatails,{headers}).pipe(
      map((res:any)=> res));
  }

}
