import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignupService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  
  contactForm: FormGroup;
  updateUser: boolean =false;
  userTable = [];
  UserObje = {};
  title = 'full-stack';
  registeredMessage: boolean = false;
  hideUserDetails: boolean=false;

  constructor(
    private fb: FormBuilder,
    private signup: SignupService
    
    ) { }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
        userId: ['', [Validators.required]],
        userName: ['', [Validators.required]],
        mobileNo: ['', [Validators.required]],
        email: ['', [Validators.required]],
        password: ['', [Validators.required]]

    });  
      
  }

  closeIcone(){
    this.registeredMessage = false;
  }

  close(){
    this.hideUserDetails=true;
    window.location.reload();
  }

  onSubmit() {
    if(this.contactForm.value == ""){
      debugger
      return;
    }else{
      debugger
      
      this.signup.addUser(this.contactForm.value).subscribe(res=>{
          console.log(res)
      })
    }
 
    }
  
}
