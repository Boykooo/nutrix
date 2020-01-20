import { FormControl, Validators } from "@angular/forms";
import { Credentials }             from "../../entity/credentials";
import { BaseFormGroup }           from "../../../../shared/model/system/base-form-group";

export class SignInValidation extends BaseFormGroup {

  constructor() {
    super({
      'email': new FormControl('', [Validators.required, Validators.email]),
      'password': new FormControl('', [Validators.required])
    });
  }

  toCredentials(): Credentials {
    return {
      email: this.get('email').value,
      password: this.get('password').value
    }
  }

}
