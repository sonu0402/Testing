import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmergencyModalComponent } from './emergency-modal.component';

describe('EmergencyModalComponent', () => {
  let component: EmergencyModalComponent;
  let fixture: ComponentFixture<EmergencyModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmergencyModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmergencyModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
