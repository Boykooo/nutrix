import { Injectable }    from "@angular/core";
import { TokenHolder }   from "./entity/token-holder";
import { CookieService } from "ngx-cookie-service";

@Injectable({ providedIn: 'root' })
export class TokenService {

  private static readonly ACCESS_TOKEN_HADER = "at";
  private static readonly REFRESH_TOKEN_HADER = "rt";
  private static readonly EXPIRED_TOKEN_HADER = "expt";

  constructor(private cookieService: CookieService) {
  }

  hasValidToken(): boolean {
    let at = this.cookieService.get(TokenService.ACCESS_TOKEN_HADER);
    return !!at && this.tokenIsNotExpired();
  }

  save(th: TokenHolder) {
    this.cookieService.set(TokenService.ACCESS_TOKEN_HADER, th.accessToken);
    this.cookieService.set(TokenService.REFRESH_TOKEN_HADER, th.refreshToken);
    this.cookieService.set(TokenService.EXPIRED_TOKEN_HADER, th.expiredTime);
  }

  tokenIsNotExpired(): boolean {
    let expiredDateString = this.cookieService.get(TokenService.EXPIRED_TOKEN_HADER);
    return expiredDateString && Date.parse(expiredDateString) > Date.now();
  }

  clear() {
    this.cookieService.delete(TokenService.ACCESS_TOKEN_HADER);
    this.cookieService.delete(TokenService.REFRESH_TOKEN_HADER);
    this.cookieService.delete(TokenService.EXPIRED_TOKEN_HADER);
  }

}
