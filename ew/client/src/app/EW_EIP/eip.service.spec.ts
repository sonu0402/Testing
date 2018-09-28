import { TestBed, inject } from '@angular/core/testing';

import { EIPService } from './eip.service';

describe('EIPService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EIPService]
    });
  });

  it('should be created', inject([EIPService], (service: EIPService) => {
    expect(service).toBeTruthy();
  }));
});
