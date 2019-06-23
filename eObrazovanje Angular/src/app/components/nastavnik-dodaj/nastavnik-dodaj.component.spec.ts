import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikDodajComponent } from './nastavnik-dodaj.component';

describe('NastavnikDodajComponent', () => {
  let component: NastavnikDodajComponent;
  let fixture: ComponentFixture<NastavnikDodajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NastavnikDodajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikDodajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
