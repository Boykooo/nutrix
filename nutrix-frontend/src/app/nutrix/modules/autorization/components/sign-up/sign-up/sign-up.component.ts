import { Component, ContentChild, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatHorizontalStepper, MatStepper } from "@angular/material/stepper";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.sass']
})
export class SignUpComponent {

  step: number = 1;

  @ViewChild('stepper', {static: false})
  stepper: MatHorizontalStepper;

  constructor() {
  }

  next() {
    console.log(this.stepper);
    this.step++;
    this.stepper.next();
  }

  back() {
    this.step--;
    this.stepper.previous();
  }

}
