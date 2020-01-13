import { UserGoal } from "../../../shared/model/entity/user-goal";
import { Gender } from "../../../shared/model/entity/gender";

export class SignUpParams {
  goal: UserGoal;
  gender: Gender;
}
