import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMatiereComponent } from './create-matiere.component';

describe('CreateMatiereComponent', () => {
  let component: CreateMatiereComponent;
  let fixture: ComponentFixture<CreateMatiereComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateMatiereComponent]
    });
    fixture = TestBed.createComponent(CreateMatiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
