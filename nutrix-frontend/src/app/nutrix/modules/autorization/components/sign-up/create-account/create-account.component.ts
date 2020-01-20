import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { SignUpValidation }                         from "./sign-up.validation";
import { Router }                                   from "@angular/router";
import { LoginService }                             from "../../../service/login.service";
import { SignUpProgressService }                    from "../../../service/sign-up-progress.service";
import { CredentialsRegisterData }                  from "../../../entity/credentials-register-data";

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.sass']
})
export class CreateAccountComponent implements OnInit {

  @ViewChild("passwordInput", { static: true })
  passwordInput: ElementRef<HTMLInputElement>;
  passwordVisible: boolean = false;
  validation: SignUpValidation = new SignUpValidation();

  constructor(private loginService: LoginService,
              private signUpProgressService: SignUpProgressService,
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
    if (this.validation.valid) {
      this.loginService.register(this.getRegisterData())
        .subscribe(() => this.router.navigateByUrl("/"));
    }
  }

  getRegisterData(): CredentialsRegisterData {
    let physicalData = this.signUpProgressService.getProgress();
    physicalData.name = this.validation.getProperty('name');
    return {
      email: this.validation.getProperty("email"),
      password: this.validation.getProperty("password"),
      physicalData: physicalData
    };
  }

}
