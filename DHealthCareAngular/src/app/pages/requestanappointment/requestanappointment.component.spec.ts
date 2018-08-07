import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestanappointmentComponent } from './requestanappointment.component';

describe('RequestanappointmentComponent', () => {
  let component: RequestanappointmentComponent;
  let fixture: ComponentFixture<RequestanappointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestanappointmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestanappointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
