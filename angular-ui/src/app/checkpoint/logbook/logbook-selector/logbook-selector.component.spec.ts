import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogbookSelectorComponent } from './logbook-selector.component';

describe('LogbookSelectorComponent', () => {
  let component: LogbookSelectorComponent;
  let fixture: ComponentFixture<LogbookSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogbookSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogbookSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
