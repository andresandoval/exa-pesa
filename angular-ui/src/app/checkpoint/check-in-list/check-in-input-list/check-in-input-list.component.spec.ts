import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckInInputListComponent } from './check-in-input-list.component';

describe('CheckInInputListComponent', () => {
  let component: CheckInInputListComponent;
  let fixture: ComponentFixture<CheckInInputListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckInInputListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckInInputListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
