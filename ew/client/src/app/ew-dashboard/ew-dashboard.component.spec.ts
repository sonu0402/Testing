import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EWDashboardComponent } from './ew-dashboard.component';

describe('EWDashboardComponent', () => {
  let component: EWDashboardComponent;
  let fixture: ComponentFixture<EWDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EWDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EWDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
