import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsersCourseComponent } from './admin-users-course.component';

describe('AdminUsersCourseComponent', () => {
  let component: AdminUsersCourseComponent;
  let fixture: ComponentFixture<AdminUsersCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminUsersCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUsersCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
