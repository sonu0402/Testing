import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenefitModalComponent } from './benefit-modal.component';

describe('BenefitModalComponent', () => {
  let component: BenefitModalComponent;
  let fixture: ComponentFixture<BenefitModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenefitModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenefitModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
