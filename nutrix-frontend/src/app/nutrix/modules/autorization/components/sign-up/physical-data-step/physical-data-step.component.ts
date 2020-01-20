import { Component, EventEmitter, Output } from '@angular/core';
import { PhysicalDataValidation }          from "./physical-data.validation";
import { SignUpProgressService }           from "../../../service/sign-up-progress.service";

@Component({
  selector: 'app-physical-data-step',
  templateUrl: './physical-data-step.component.html',
  styleUrls: ['./physical-data-step.component.sass']
})
export class PhysicalDataStepComponent {

  @Output()
  physicDataSetted = new EventEmitter();
  validation: PhysicalDataValidation = new PhysicalDataValidation();

  constructor(private signUpProgressService: SignUpProgressService) {
  }

  next() {
    this.validation.setAllDirty();
    console.log(this.validation);
    if (this.validation.valid) {
      let physicalData = this.validation.toPhysicalData();
      this.signUpProgressService.setPhysicalData(physicalData);
      this.physicDataSetted.emit();
    }
  }

}
