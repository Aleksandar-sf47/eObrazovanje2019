import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PredmetDodajComponent } from './predmet-dodaj.component';

describe('PredmetDodajComponent', () => {
  let component: PredmetDodajComponent;
  let fixture: ComponentFixture<PredmetDodajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredmetDodajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredmetDodajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
