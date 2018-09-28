import { TestBed, inject } from '@angular/core/testing';

import { OBService } from './ob.service';

describe('OBService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OBService]
    });
  });

  it('should be created', inject([OBService], (service: OBService) => {
    expect(service).toBeTruthy();
  }));
});
