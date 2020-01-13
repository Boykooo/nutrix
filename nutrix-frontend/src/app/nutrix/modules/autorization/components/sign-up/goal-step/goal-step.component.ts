import { Component, EventEmitter, Output } from '@angular/core';
import { UserGoal } from "../../../../../shared/model/entity/user-goal";
import { SignUpProgressService } from "../../../service/sign-up-progress.service";

@Component({
  selector: 'app-goal-step',
  templateUrl: './goal-step.component.html',
  styleUrls: ['./goal-step.component.sass']
})
export class GoalStepComponent {

  @Output()
  goalSelected = new EventEmitter();
  UserGoal = UserGoal;

  constructor(private signUpProgressService: SignUpProgressService) {
  }

  selectGoal(goal: UserGoal) {
    this.signUpProgressService.setGoal(goal);
    this.goalSelected.emit();
  }

}
