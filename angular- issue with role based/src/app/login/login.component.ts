import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { MenuComponent } from '../menu/menu.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;
  message :any;
  
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(private service : AppService,
              private router : Router) { }

  ngOnInit(): void {

    
  } 

  // doLogin(){
  //   let resp = this.service.login(this.username,this.password);
  //   debugger
  //   resp.subscribe(data=>{   
  //     this.router.navigate(["/user"]);
  //     return true;
  //   });
  // }

  doLogin() {
    this.service.authenticationService(this.username, this.password).subscribe((result)=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      
      this.successMessage = 'Login Successful.';
      localStorage.setItem('username',this.username);
      localStorage.setItem('password',this.password);

      if(result == "[ADMIN]"){
        localStorage.setItem('LoggedInUser',"admin");
        this.router.navigateByUrl('/admin');
        
      } else if(result == "[USER]"){ 
        localStorage.setItem('LoggedInUser',"user");
        this.router.navigate(['/user']);
        // this.router.navigate(['/manage']);
      }

      // if(result == "[ADMIN]"){
      //  this.router.navigate(['/admin-home']);
      // }
      // else if(result == "[USER]"){
      // this.router.navigate(['/course']);
      // }

    }, () => {
      this.invalidLogin = true;
      localStorage.setItem('LoggedInUser',"failed");
      this.loginSuccess = false;
    });      
  } 

}
