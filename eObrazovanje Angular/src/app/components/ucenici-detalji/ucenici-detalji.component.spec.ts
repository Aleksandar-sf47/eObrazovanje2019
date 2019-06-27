import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UceniciDetaljiComponent } from './ucenici-detalji.component';

describe('UceniciDetaljiComponent', () => {
  let component: UceniciDetaljiComponent;
  let fixture: ComponentFixture<UceniciDetaljiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UceniciDetaljiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UceniciDetaljiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
