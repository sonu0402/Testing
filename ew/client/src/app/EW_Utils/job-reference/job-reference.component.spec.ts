import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JobReferenceComponent } from './job-reference.component';

describe('JobReferenceComponent', () => {
  let component: JobReferenceComponent;
  let fixture: ComponentFixture<JobReferenceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JobReferenceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JobReferenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
