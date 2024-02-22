import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatiereDetailsComponent } from './matiere-details.component';

describe('MatiereDetailsComponent', () => {
  let component: MatiereDetailsComponent;
  let fixture: ComponentFixture<MatiereDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MatiereDetailsComponent]
    });
    fixture = TestBed.createComponent(MatiereDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
