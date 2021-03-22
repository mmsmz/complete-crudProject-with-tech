import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CourseService } from './course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  contactForm: FormGroup;
  updateCourseDetails: FormGroup;
  updateCourse: boolean =false;
  userTable = [];
  UserObje = {};
  title = 'full-stack';
  registeredMessage: boolean = false;
  hideUserDetails: boolean=false;
  
  constructor(
    private fb: FormBuilder,
    
    private crsService: CourseService
    ) { }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
      courseID: ['', [Validators.required]],
      courseName: ['', [Validators.required]],
      coursePrice: ['', [Validators.required]]
    });
    this.userDeatailsFn();
    this.crsService.getAllCourses().subscribe(res=>{
      this.userTable = res.data;
    })
  }

  closeIcone(){
    this.registeredMessage = false;
  }

  close(){
    this.hideUserDetails=true;
    window.location.reload();
  }

  userDeatailsFn(){
    this.updateCourseDetails = this.fb.group({
      courseID: ['', [Validators.required]],
      courseName: ['', [Validators.required]],
      coursePrice: ['', [Validators.required]]
    });
  }

  UpdateCourse(td){
    this.updateCourse = true;
    // this.UserObje = {
    //   userid : td.userid,
    //   username : td.name,
    // }
    this.updateCourseDetails.controls['userId'].setValue(td.userId);
    this.updateCourseDetails.controls['name'].setValue(td.name);
    this.updateCourseDetails.controls['price'].setValue(td.price);
  }

  onUpdate(){
    if(this.updateCourseDetails.value == ""){
      return;
    }else{
      debugger;
      this.crsService.updateCourse(this.updateCourseDetails.value).subscribe(res=>{
        debugger;
        this.crsService.getAllCourses().subscribe(res=>{
          debugger;
          this.userTable = res.data;
        })
      })
    }
    window.location.reload();
  }

  submitFilter(){
    debugger;
    this.crsService.getCourseById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res.data;
    })
  }

  onSubmit() {
    if(this.contactForm.value == ""){
      return;
    }else{
      debugger
      if(this.contactForm.value.name!=""){
      this.crsService.addCourse(this.contactForm.value).subscribe(res=>{
        this.crsService.getAllCourses().subscribe(res=>{
          this.userTable = res.data;
        })
      })
    }
    else{
      debugger;
    this.crsService.getCourseById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res.data;
    })
    }
    }
  }

  delete(td){
    let user = {
      userId : td.userId,
      name : td.userId,
      price : td.price
    }
    this.crsService.deleteCourse(user).subscribe(res=>{
    
      // this.crsService.getAllCourses().subscribe(res=>{
      //   this.userTable = res.data;
      // })
    })
  }

}