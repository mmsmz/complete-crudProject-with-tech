import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageUserCourseComponent } from './manage-user-course.component';

describe('ManageUserCourseComponent', () => {
  let component: ManageUserCourseComponent;
  let fixture: ComponentFixture<ManageUserCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageUserCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageUserCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
