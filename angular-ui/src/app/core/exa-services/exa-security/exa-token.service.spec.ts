import { TestBed, inject } from '@angular/core/testing';

import { ExaTokenService } from './exa-token.service';

describe('ExaTokenService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaTokenService]
    });
  });

  it('should be created', inject([ExaTokenService], (service: ExaTokenService) => {
    expect(service).toBeTruthy();
  }));
});
