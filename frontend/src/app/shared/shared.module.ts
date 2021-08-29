import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from './form/form.component';
import { InputFeedbackComponent } from './input-feedback/input-feedback.component';

@NgModule({
  declarations: [
    FormComponent,
    InputFeedbackComponent
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
