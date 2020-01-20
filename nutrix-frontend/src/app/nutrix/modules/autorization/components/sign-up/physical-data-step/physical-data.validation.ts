import { BaseFormGroup }           from "../../../../../shared/model/system/base-form-group";
import { FormControl, Validators } from "@angular/forms";
import { ShortPhysicalData }       from "../../../entity/short-physical-data";

export class PhysicalDataValidation extends BaseFormGroup {
  constructor() {
    super({
      'birthday': new FormControl('', Validators.required),
      'height': new FormControl('', [Validators.required, Validators.min(100), Validators.max(270)]),
      'weight': new FormControl('', [Validators.required, Validators.min(30), Validators.max(360)]),
      'targetWeight': new FormControl('', [Validators.required, Validators.min(30), Validators.max(360)])
    })
  }

  toPhysicalData(): ShortPhysicalData {
    return {
      birthday: this.get('birthday').value,
      height: this.get('height').value,
      weight: this.get('weight').value,
      targetWeight: this.get('targetWeight').value
    }
  }

}
