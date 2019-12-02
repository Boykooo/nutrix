import { Injectable }   from "@angular/core";
import { TokenService } from "./token.service";

@Injectable({ providedIn: 'root' })
export class AuthService {

  constructor(private tokenService: TokenService) {
  }

  isAuthorized(): boolean {
    return this.tokenService.hasValidToken();
  }

}
