import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormComponent } from 'src/app/shared/form/form.component';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent extends FormComponent implements OnInit {
  userForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    super();
  }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      name: ['', [Validators.required]], 
    });
  }

  public create(): void {
    console.log('create');
    console.log(this.userForm)
    this.validate(this.userForm);
    if (this.userForm.invalid) {
      console.log('invalid');
      return;
    }
  }

  public update(): void {

  }

  public delete(): void {

  }

  list(): void {

  }
}
