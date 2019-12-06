import { FormControl, FormGroup, Validators } from "@angular/forms";
import { RegisterData }                       from "../../../../security/entity/register-data";

export class SignUpValidation extends FormGroup {

  constructor() {
    super({
      'name': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'email': new FormControl('', [Validators.required, Validators.email]),
      'password': new FormControl('', [Validators.required, Validators.minLength(8)]),
      'terms': new FormControl('', [Validators.required, Validators.requiredTrue])
    })
  }

  hasError(field: string, error: string): boolean {
    return this.get(field).hasError(error);
  }

  isDirty(field: string): boolean {
    return this.get(field).dirty;
  }

  setAllDirty() {
    Object.values(this.controls).forEach(control => {
      control.markAsDirty();
    });
  }

  toEntity(): RegisterData {
    return {
      name: this.get('name').value,
      email: this.get('email').value,
      password: this.get('password').value
    }
  }

}
