import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewVolunteerComponent } from './review-volunteer.component';

describe('ReviewVolunteerComponent', () => {
  let component: ReviewVolunteerComponent;
  let fixture: ComponentFixture<ReviewVolunteerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewVolunteerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewVolunteerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
