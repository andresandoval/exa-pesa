import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogbookOutputNewComponent } from './logbook-output-new.component';

describe('LogbookOutputNewComponent', () => {
  let component: LogbookOutputNewComponent;
  let fixture: ComponentFixture<LogbookOutputNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogbookOutputNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogbookOutputNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
