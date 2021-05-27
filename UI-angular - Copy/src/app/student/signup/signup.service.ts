import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http : HttpClient) { }

  addUser(data: any){
    let username = localStorage.getItem('username');
    let password = localStorage.getItem('password');
    debugger
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
    return this.http.post("http://localhost:8070/homeService/register", data, {headers}).pipe(
      map((res:any)=> res));
  }


}
