import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EwLoginComponent } from './ew-login.component';

describe('EwLoginComponent', () => {
  let component: EwLoginComponent;
  let fixture: ComponentFixture<EwLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EwLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EwLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
