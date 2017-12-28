import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckInOutputListComponent } from './check-in-output-list.component';

describe('CheckInOutputListComponent', () => {
  let component: CheckInOutputListComponent;
  let fixture: ComponentFixture<CheckInOutputListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckInOutputListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckInOutputListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
