import { UserGoal } from "../../../shared/model/entity/user-goal";
import { Gender }   from "../../../shared/model/entity/gender";

export class AccountPhysicalData {
  name: string;
  goal: UserGoal;
  gender: Gender;
  birthday: string;
  height: number;
  weight: number;
  targetWeight: number;
}
