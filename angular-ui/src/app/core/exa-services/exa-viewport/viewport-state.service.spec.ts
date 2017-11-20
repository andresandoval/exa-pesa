import { TestBed, inject } from '@angular/core/testing';

import { ViewportStateService } from './viewport-state.service';

describe('ViewportStateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ViewportStateService]
    });
  });

  it('should be created', inject([ViewportStateService], (service: ViewportStateService) => {
    expect(service).toBeTruthy();
  }));
});
