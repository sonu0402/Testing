import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileDetailsModalComponent } from './profile-details-modal.component';

describe('ProfileDetailsModalComponent', () => {
  let component: ProfileDetailsModalComponent;
  let fixture: ComponentFixture<ProfileDetailsModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileDetailsModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileDetailsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
