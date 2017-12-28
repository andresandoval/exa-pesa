import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogbookListComponent } from './logbook-list.component';

describe('LogbookListComponent', () => {
  let component: LogbookListComponent;
  let fixture: ComponentFixture<LogbookListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogbookListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogbookListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
