import { FormGroup } from "@angular/forms";

export class BaseFormGroup extends FormGroup {

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

}
