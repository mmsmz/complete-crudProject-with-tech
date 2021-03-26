import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppService } from '../app.service';
import { UserService } from './user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html', 
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  contactForm: FormGroup;
  updateUserDetails: FormGroup;
  updateUser: boolean =false;
  userTable = [];
  UserObje = {};
  title = 'full-stack';
  registeredMessage: boolean = false;
  hideUserDetails: boolean=false;

  constructor(
    private fb: FormBuilder,
    private userService: UserService
    
    ) { }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
        userId: ['', [Validators.required]],
        username: ['', [Validators.required]],
        email: ['', [Validators.required]]
    });
    this.userDeatailsFn();
    debugger
    this.userService.getAlluser().subscribe(res=>{
      // console.log(res['data'])
       this.userTable = res['data'];
    }) 
    debugger
  }

  closeIcone(){
    this.registeredMessage = false;
  }

  close(){
    this.hideUserDetails=true;
    window.location.reload();
  }

  userDeatailsFn(){
    this.updateUserDetails = this.fb.group({
      userId: ['', [Validators.required]],
      username: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
  }

  UpdateUSer(td){
    this.updateUser = true;
    // this.UserObje = {
    //   userid : td.userid,
    //   username : td.name,
    // }
    debugger;
    this.updateUserDetails.controls['userId'].setValue(td.userId);
    this.updateUserDetails.controls['username'].setValue(td.username);
    this.updateUserDetails.controls['email'].setValue(td.email);
  }

  onUpdate(){
    if(this.updateUserDetails.value == ""){
      return;
    }else{
      debugger;
      this.userService.updateUser(this.updateUserDetails.value).subscribe(res=>{
        debugger;
        this.userService.getAlluser().subscribe(res=>{
          debugger;
          this.userTable = res['data'];
        })
      })
    }
    window.location.reload();
  }

  submitFilter(){
    debugger;
    this.userService.getUserById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res['data'];
    })
  }

  onSubmit() {
    if(this.contactForm.value == ""){
      return;
    }else{
      debugger
      if(this.contactForm.value.username&&this.contactForm.value.email!=""){
      this.userService.addUser(this.contactForm.value).subscribe(res=>{
        this.userService.getAlluser().subscribe(res=>{
          this.userTable = res['data'];
        })
      })
    }
    else{
      debugger;
    this.userService.getUserById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res['data'];
    })
    }
    }
  }

  delete(td){
    let user = {
      userId : td.userId,
      username : td.username,
      email : td.email
    }
    debugger
    this.userService.deleteUser(user).subscribe(res=>{
    
      this.userService.getAlluser().subscribe(res=>{
        this.userTable = res['data'];
      })
    })
  }

}
