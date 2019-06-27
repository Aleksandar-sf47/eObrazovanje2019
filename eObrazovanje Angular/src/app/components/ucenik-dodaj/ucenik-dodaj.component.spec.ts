import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UcenikDodajComponent } from './ucenik-dodaj.component';

describe('UcenikDodajComponent', () => {
  let component: UcenikDodajComponent;
  let fixture: ComponentFixture<UcenikDodajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UcenikDodajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UcenikDodajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
