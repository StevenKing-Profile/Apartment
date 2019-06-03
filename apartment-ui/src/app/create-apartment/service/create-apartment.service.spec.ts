import { TestBed, inject } from '@angular/core/testing';

import { CreateApartmentService } from './create-apartment.service';

describe('CreateApartmentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateApartmentService]
    });
  });

  it('should be created', inject([CreateApartmentService], (service: CreateApartmentService) => {
    expect(service).toBeTruthy();
  }));
});
