import { Component, ContentChild, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatHorizontalStepper, MatStepper } from "@angular/material/stepper";
import { SignUpProgressService } from "../../../service/sign-up-progress.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.sass']
})
export class SignUpComponent implements OnInit {

  step: number = 1;

  @ViewChild('stepper', {static: false})
  stepper: MatHorizontalStepper;

  constructor(private signUpProgressService: SignUpProgressService) {
  }

  ngOnInit(): void {
    this.signUpProgressService.clear();
  }

  next() {
    this.step++;
    this.stepper.next();
  }

  back() {
    if (this.step > 1) {
      this.step--;
      this.stepper.previous();
    }
  }

}
