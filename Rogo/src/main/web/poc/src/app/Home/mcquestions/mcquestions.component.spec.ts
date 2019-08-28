import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { McquestionsComponent } from './mcquestions.component';

describe('McquestionsComponent', () => {
  let component: McquestionsComponent;
  let fixture: ComponentFixture<McquestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ McquestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(McquestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
