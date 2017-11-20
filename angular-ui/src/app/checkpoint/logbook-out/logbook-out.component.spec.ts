import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogbookOutComponent } from './logbook-out.component';

describe('LogbookOutComponent', () => {
  let component: LogbookOutComponent;
  let fixture: ComponentFixture<LogbookOutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogbookOutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogbookOutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
