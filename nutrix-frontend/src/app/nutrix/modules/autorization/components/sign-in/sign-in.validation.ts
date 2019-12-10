import { BaseFormGroup }           from "../../../../shared/entity/system/base-form-group";
import { FormControl, Validators } from "@angular/forms";
import { Credentials }             from "../../../../security/entity/credentials";

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
