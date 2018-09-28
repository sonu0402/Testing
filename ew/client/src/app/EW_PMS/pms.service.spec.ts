import { TestBed, inject } from '@angular/core/testing';

import { PMSService } from './pms.service';

describe('PMSService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PMSService]
    });
  });

  it('should be created', inject([PMSService], (service: PMSService) => {
    expect(service).toBeTruthy();
  }));
});
