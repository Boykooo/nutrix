import { Injectable }    from "@angular/core";
import { TokenHolder }   from "./entity/token-holder";
import { CookieService } from "ngx-cookie-service";

@Injectable({ providedIn: 'root' })
export class TokenService {

  private readonly ACCESS_TOKEN_HADER = "at";
  private readonly REFRESH_TOKEN_HADER = "rt";
  private readonly EXPIRED_TOKEN_HADER = "expt";

  constructor(private cookieService: CookieService) {
  }

  hasValidToken(): boolean {
    let at = this.cookieService.get(this.ACCESS_TOKEN_HADER);
    return !!at && this.tokenIsNotExpired();
  }

  save(th: TokenHolder) {
    console.log('test');
    this.cookieService.set(this.ACCESS_TOKEN_HADER, th.accessToken);
    this.cookieService.set(this.REFRESH_TOKEN_HADER, th.refreshToken);
    this.cookieService.set(this.EXPIRED_TOKEN_HADER, th.expiredTime);
  }

  tokenIsNotExpired(): boolean {
    let expiredDateString = this.cookieService.get(this.EXPIRED_TOKEN_HADER);
    return expiredDateString && Date.parse(expiredDateString) > Date.now();
  }

  clear() {
    this.cookieService.delete(this.ACCESS_TOKEN_HADER);
    this.cookieService.delete(this.REFRESH_TOKEN_HADER);
    this.cookieService.delete(this.EXPIRED_TOKEN_HADER);
  }

}
