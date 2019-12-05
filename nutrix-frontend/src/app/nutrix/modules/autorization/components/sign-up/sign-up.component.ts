import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { SignUpValidation }                         from "./sign-up.validation";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.sass']
})
export class SignUpComponent implements OnInit {

  @ViewChild("passwordInput", { static: true })
  passwordInput: ElementRef<HTMLInputElement>;
  passwordVisible: boolean = false;

  validation: SignUpValidation = new SignUpValidation();

  constructor() {
  }

  ngOnInit() {
  }

  togglePasswordVisible() {
    this.passwordVisible = !this.passwordVisible;
    if (this.passwordVisible) {
      this.passwordInput.nativeElement.type = 'text';
    } else {
      this.passwordInput.nativeElement.type = 'password';
    }
  }

  register() {
    this.validation.setAllDirty();
    if (this.validation.valid) {

    }
  }

}
