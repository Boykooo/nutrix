import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { SignInValidation }                         from "./sign-in.validation";
import { SecurityService }                          from "../../../../security/security.service";
import { ErrorParserService }                       from "../../../../shared/service/error-parser.service";
import { HttpErrorResponse }                        from "@angular/common/http";
import { Router }                                   from "@angular/router";
import { LoginService }                             from "../../service/login.service";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.sass']
})
export class SignInComponent implements OnInit {

  @ViewChild("passwordInput", { static: true })
  passwordInput: ElementRef<HTMLInputElement>;
  validation: SignInValidation = new SignInValidation();

  passwordVisible: boolean;
  signInError: string = null;

  constructor(private loginService: LoginService,
              private router: Router,
              private errorParserService: ErrorParserService) {
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

  login() {
    if (this.validation.valid) {
      let credentials = this.validation.toCredentials();
      this.loginService.login(credentials)
        .subscribe(
          () => {
            this.signInError = null;
            this.router.navigateByUrl('/');
          },
          err => this.processError(err)
        )
    }
  }

  processError(err: HttpErrorResponse) {
    this.errorParserService.parse(err)
      .subscribe(parsedError => this.signInError = parsedError)
  }

}
