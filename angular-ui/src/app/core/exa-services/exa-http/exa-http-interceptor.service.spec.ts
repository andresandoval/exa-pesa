import { TestBed, inject } from '@angular/core/testing';

import { ExaHttpInterceptorService } from './exa-http-interceptor.service';

describe('ExaHttpInterceptorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaHttpInterceptorService]
    });
  });

  it('should be created', inject([ExaHttpInterceptorService], (service: ExaHttpInterceptorService) => {
    expect(service).toBeTruthy();
  }));
});
