import { TestBed, inject } from '@angular/core/testing';

import { ExaDialogService } from './exa-dialog.service';

describe('ExaDialogService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExaDialogService]
    });
  });

  it('should be created', inject([ExaDialogService], (service: ExaDialogService) => {
    expect(service).toBeTruthy();
  }));
});
