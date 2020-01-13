import { Component, EventEmitter, Output } from '@angular/core';
import { SignUpProgressService } from "../../../service/sign-up-progress.service";
import { Gender } from 'src/app/nutrix/shared/model/entity/gender';

@Component({
  selector: 'app-gender-step',
  templateUrl: './gender-step.component.html',
  styleUrls: ['./gender-step.component.sass']
})
export class GenderStepComponent {

  @Output()
  genderSelected = new EventEmitter();
  Gender = Gender;

  constructor(private signUpProgressService: SignUpProgressService) {
  }

  selectGender(gender: Gender) {
    this.signUpProgressService.setGender(gender);
    this.genderSelected.emit();
  }

}
