import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentsAgeComponent } from './students-age.component';

describe('StudentsAgeComponent', () => {
  let component: StudentsAgeComponent;
  let fixture: ComponentFixture<StudentsAgeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentsAgeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentsAgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
