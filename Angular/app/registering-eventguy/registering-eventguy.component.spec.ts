import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteringEventguyComponent } from './registering-eventguy.component';

describe('RegisteringEventguyComponent', () => {
  let component: RegisteringEventguyComponent;
  let fixture: ComponentFixture<RegisteringEventguyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisteringEventguyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisteringEventguyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
