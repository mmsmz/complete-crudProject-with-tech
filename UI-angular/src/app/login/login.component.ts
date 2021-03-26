import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  username:string = '';
  password:string = '';
  message :any;
  
  errorMessage = 'Invalid Credentials';
  successMessage: string | undefined;
  invalidLogin = false;
  loginSuccess = false;


  constructor(private service : AppService,
    private router : Router) { }

  ngOnInit(): void {
  }

  doLogin() {
 //   this.service.authenticationService(this.username, this.password) {
      this.invalidLogin = false;
      this.loginSuccess = true;
      
      this.successMessage = 'Login Successful.';
      localStorage.setItem('username',this.username);
      localStorage.setItem('password',this.password);
     

      if(this.username == "admin"){
        localStorage.setItem('LoggedInUser',"admin");
        this.router.navigateByUrl('/admin');
        
      } else if(this.username == "user"){ 
        localStorage.setItem('LoggedInUser',"user");
        this.router.navigate(['/user']);
      }
    }
}
