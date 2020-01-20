import { Injectable }          from "@angular/core";
import { UserGoal }            from "../../../shared/model/entity/user-goal";
import { AccountPhysicalData } from "../entity/account-physical-data";
import { Gender }              from "../../../shared/model/entity/gender";
import { ShortPhysicalData }   from "../entity/short-physical-data";

/**
 * Service for saving sign up progress. Step by step
 * Need for oAuth authentication
 */
@Injectable({ providedIn: 'root' })
export class SignUpProgressService {

  private readonly PARAMS_HEADER = "signup_params";

  clear() {
    localStorage.removeItem(this.PARAMS_HEADER);
  }

  getProgress(): AccountPhysicalData {
    return this.getParams();
  }

  setGoal(goal: UserGoal) {
    let params = this.getParams();
    params.goal = goal;
    this.save(params);
  }

  setGender(gender: Gender) {
    let params = this.getParams();
    params.sex = gender;
    this.save(params);
  }

  setPhysicalData(pd: ShortPhysicalData) {
    let params = this.getParams();
    params.birthday = pd.birthday;
    params.height = pd.height;
    params.weight = pd.weight;
    params.targetWeight = pd.targetWeight;
    this.save(params);
  }

  private getParams(): AccountPhysicalData {
    let jsonProgress = localStorage.getItem(this.PARAMS_HEADER);
    return jsonProgress ? JSON.parse(jsonProgress) : new AccountPhysicalData();
  }

  private save(params: AccountPhysicalData) {
    localStorage.setItem(this.PARAMS_HEADER, JSON.stringify(params));
  }


}
