import { TestBed, inject } from '@angular/core/testing';

import { SeparationService } from './separation.service';

describe('SeparationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SeparationService]
    });
  });

  it('should be created', inject([SeparationService], (service: SeparationService) => {
    expect(service).toBeTruthy();
  }));
});
