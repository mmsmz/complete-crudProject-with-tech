import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsercoursedetailsService } from './usercoursedetails.service';

@Component({
  selector: 'app-usercoursedetails',
  templateUrl: './usercoursedetails.component.html',
  styleUrls: ['./usercoursedetails.component.css']
})
export class UsercoursedetailsComponent implements OnInit {

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
    private userStudentDetails: UsercoursedetailsService
    
    ) { }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
        userId: ['', [Validators.required]],
        courseId: ['', [Validators.required]]
        
    });
    this.userDeatailsFn();
    debugger
    // this.userStudentDetails.getAlluser().subscribe(res=>{
    //    this.userTable = res['data'];
    // }) 
    
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
      courseId: ['', [Validators.required]]
      
    });
  }

  UpdateUSer(td){
    this.updateUser = true;
    debugger;
    this.updateUserDetails.controls['userId'].setValue(td.userId);
    this.updateUserDetails.controls['courseId'].setValue(td.courseId);
    
  }

  onUpdate(){
    if(this.updateUserDetails.value == ""){
      return;
    }else{
      debugger;
      this.userStudentDetails.updateUser(this.updateUserDetails.value).subscribe(res=>{
        debugger;
        // this.userStudentDetails.getAlluser().subscribe(res=>{
        //   debugger;
        //   this.userTable = res['data'];
        // })
      })
    }
    window.location.reload();
  }

  // submitFilter(){
  //   debugger;
  //   this.userStudentDetails.getUserById(this.contactForm.value).subscribe(res=>{
  //     debugger;
  //     this.userTable = res['data'];
  //   })
  // }

  onSubmit() {
    if(this.contactForm.value == ""){
      return;
    }
    else{
      debugger
      if(this.contactForm.value.courseId!=""){
        
      this.userStudentDetails.addUser(this.contactForm.value).subscribe(res=>{
        console.log("add", res);
        debugger
        // this.userStudentDetails.getAlluser().subscribe(res=>{
        //   this.userTable = res['data'];
        // })
      })
    }
    else{
      debugger;
    this.userStudentDetails.getUserById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res['data'];
      
    })
    }
    }
  }

  delete(td){
    let user = {
      userId : td.userId,
      courseId : td.courseId
    }
    debugger
    this.userStudentDetails.deleteUser(user).subscribe(res=>{
    
      // this.userStudentDetails.getAlluser().subscribe(res=>{
      //   this.userTable = res['data'];
      // })
    })
  }

}
