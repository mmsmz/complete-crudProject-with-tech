import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsercoursedetailsComponent } from './usercoursedetails.component';

describe('UsercoursedetailsComponent', () => {
  let component: UsercoursedetailsComponent;
  let fixture: ComponentFixture<UsercoursedetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsercoursedetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsercoursedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
