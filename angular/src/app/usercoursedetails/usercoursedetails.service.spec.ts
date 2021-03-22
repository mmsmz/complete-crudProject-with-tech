import { TestBed } from '@angular/core/testing';

import { UsercoursedetailsService } from './usercoursedetails.service';

describe('UsercoursedetailsService', () => {
  let service: UsercoursedetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsercoursedetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
