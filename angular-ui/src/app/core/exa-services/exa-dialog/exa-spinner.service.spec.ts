import { TestBed, inject } from '@angular/core/testing';

import { ExaSpinnerService } from './exa-spinner.service';

describe('ExaSpinnerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaSpinnerService]
    });
  });

  it('should be created', inject([ExaSpinnerService], (service: ExaSpinnerService) => {
    expect(service).toBeTruthy();
  }));
});
