import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EwDashboardSearchComponent } from './ew-dashboard-search.component';

describe('EwDashboardSearchComponent', () => {
  let component: EwDashboardSearchComponent;
  let fixture: ComponentFixture<EwDashboardSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EwDashboardSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EwDashboardSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
