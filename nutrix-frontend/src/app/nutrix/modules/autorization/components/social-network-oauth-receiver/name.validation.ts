import { BaseFormGroup }           from "../../../../shared/entity/system/base-form-group";
import { FormControl, Validators } from "@angular/forms";

export class NameValidation extends BaseFormGroup {

  constructor() {
    super({
      'name': new FormControl('', [Validators.required, Validators.minLength(8)])
    })
  }

  getName(): string {
    return this.get('name').value;
  }

}
