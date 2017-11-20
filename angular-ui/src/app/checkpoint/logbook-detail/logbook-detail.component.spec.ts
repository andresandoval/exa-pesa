import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogbookDetailComponent } from './logbook-detail.component';

describe('LogbookDetailComponent', () => {
  let component: LogbookDetailComponent;
  let fixture: ComponentFixture<LogbookDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogbookDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogbookDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
