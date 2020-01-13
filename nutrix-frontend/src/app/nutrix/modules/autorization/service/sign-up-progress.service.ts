import { Injectable } from "@angular/core";
import { UserGoal } from "../../../shared/model/entity/user-goal";
import { SignUpParams } from "../entity/sign-up-params";
import { Gender } from "../../../shared/model/entity/gender";

@Injectable({providedIn: 'root'})
export class SignUpProgressService {

  private readonly PARAMS_HEADER = "signup_params";

  clear() {
    localStorage.removeItem(this.PARAMS_HEADER);
  }

  setGoal(goal: UserGoal) {
    let params = this.getParams();
    params.goal = goal;
    this.save(params);
  }

  setGender(gender: Gender) {
    let params = this.getParams();
    params.gender = gender;
    this.save(params);
  }

  private getParams(): SignUpParams {
    let jsonProgress = localStorage.getItem(this.PARAMS_HEADER);
    return jsonProgress ? JSON.parse(jsonProgress) : new SignUpParams();
  }

  private save(params: SignUpParams) {
    localStorage.setItem(this.PARAMS_HEADER, JSON.stringify(params));
  }

}
