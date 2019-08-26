import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UcenikHomeComponent } from './ucenik-home.component';

describe('UcenikHomeComponent', () => {
  let component: UcenikHomeComponent;
  let fixture: ComponentFixture<UcenikHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UcenikHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UcenikHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
