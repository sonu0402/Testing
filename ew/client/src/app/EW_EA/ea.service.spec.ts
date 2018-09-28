import { TestBed, inject } from '@angular/core/testing';

import { EAService } from './ea.service';

describe('EAService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EAService]
    });
  });

  it('should be created', inject([EAService], (service: EAService) => {
    expect(service).toBeTruthy();
  }));
});
