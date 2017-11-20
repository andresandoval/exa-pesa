import { TestBed, inject } from '@angular/core/testing';

import { ExaHttpService } from './exa-http.service';

describe('ExaHttpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaHttpService]
    });
  });

  it('should be created', inject([ExaHttpService], (service: ExaHttpService) => {
    expect(service).toBeTruthy();
  }));
});
