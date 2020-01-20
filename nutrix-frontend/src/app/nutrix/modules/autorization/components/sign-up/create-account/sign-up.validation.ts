import { FormControl, Validators } from "@angular/forms";
import { BaseFormGroup }           from "../../../../../shared/model/system/base-form-group";

export class SignUpValidation extends BaseFormGroup {

  constructor() {
    super({
      'name': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'email': new FormControl('', [Validators.required, Validators.email]),
      'password': new FormControl('', [Validators.required, Validators.minLength(8)]),
      'terms': new FormControl('', [Validators.required, Validators.requiredTrue])
    })
  }

  getProperty(name: string) {
    return this.get(name).value;
  }

}
