import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AppService {

   // BASE_PATH: 'http://localhost:8087'
   USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';
    
  //  public username: String;
  //  public password: String;
  
  constructor(private http: HttpClient,
              private router: Router) { }

  // public login(username:string, password:string){
  //   const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
  //   return  this.http.get("http://localhost:8087/", {headers, responseType: 'text' as 'json'});
  // }  

  authenticationService(username: String, password: String) {    
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
    return  this.http.get("http://localhost:8071/", {headers, responseType: 'text' as 'json'});
  }

   logout() {
    localStorage.removeItem("username");
    localStorage.removeItem("password");
    localStorage.removeItem("LoggedInUser");

    this.router.navigateByUrl('/login');

   }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  // createBasicAuthToken(username: String, password: String) {
  //   return 'Basic ' + window.btoa(username + ":" + password)
  // }
}
