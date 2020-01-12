import { FormControl, FormGroup, Validators } from "@angular/forms";
import { RegisterData }                       from "../../../../../security/entity/register-data";
import { BaseFormGroup } from "../../../../../shared/model/system/base-form-group";

export class SignUpValidation extends BaseFormGroup {

  constructor() {
    super({
      'name': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'email': new FormControl('', [Validators.required, Validators.email]),
      'password': new FormControl('', [Validators.required, Validators.minLength(8)]),
      'terms': new FormControl('', [Validators.required, Validators.requiredTrue])
    })
  }

  toEntity(): RegisterData {
    return {
      name: this.get('name').value,
      email: this.get('email').value,
      password: this.get('password').value
    }
  }

}
