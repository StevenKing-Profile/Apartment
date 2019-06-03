import { TestBed, inject } from '@angular/core/testing';

import { ApartmentListService } from './apartment-list.service';

describe('ApartmentListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApartmentListService]
    });
  });

  it('should be created', inject([ApartmentListService], (service: ApartmentListService) => {
    expect(service).toBeTruthy();
  }));
});
