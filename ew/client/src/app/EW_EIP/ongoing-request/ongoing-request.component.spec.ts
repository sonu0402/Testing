import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OngoingRequestComponent } from './ongoing-request.component';

describe('OngoingRequestComponent', () => {
  let component: OngoingRequestComponent;
  let fixture: ComponentFixture<OngoingRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OngoingRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OngoingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
