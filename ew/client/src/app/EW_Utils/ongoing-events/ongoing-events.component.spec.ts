import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OngoingEventsComponent } from './ongoing-events.component';

describe('OngoingEventsComponent', () => {
  let component: OngoingEventsComponent;
  let fixture: ComponentFixture<OngoingEventsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OngoingEventsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OngoingEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
