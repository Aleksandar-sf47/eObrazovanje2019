import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikHomeComponent } from './nastavnik-home.component';

describe('NastavnikHomeComponent', () => {
  let component: NastavnikHomeComponent;
  let fixture: ComponentFixture<NastavnikHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NastavnikHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
