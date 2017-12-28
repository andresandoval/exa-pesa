import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogbookInputNewComponent } from './logbook-input-new.component';

describe('LogbookNewInComponent', () => {
  let component: LogbookInputNewComponent;
  let fixture: ComponentFixture<LogbookInputNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogbookInputNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogbookInputNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
