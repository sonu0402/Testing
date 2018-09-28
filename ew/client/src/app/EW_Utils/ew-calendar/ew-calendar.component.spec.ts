import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EwCalendarComponent } from './ew-calendar.component';

describe('EwCalendarComponent', () => {
  let component: EwCalendarComponent;
  let fixture: ComponentFixture<EwCalendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EwCalendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EwCalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
