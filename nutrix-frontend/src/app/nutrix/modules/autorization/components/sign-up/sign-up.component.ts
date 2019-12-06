import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { SignUpValidation }                         from "./sign-up.validation";
import { AuthService }                              from "../../../../security/auth.service";
import { Router }                                   from "@angular/router";

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

  constructor(private authService: AuthService,
              private router: Router) {
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
    console.log(this.validation.valid);
    if (this.validation.valid) {
      let registerData = this.validation.toEntity();
      this.authService.register(registerData).subscribe();
    }
  }

}
