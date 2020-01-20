import { Injectable }   from "@angular/core";
import { TokenService } from "./token.service";
import { Router }       from "@angular/router";

@Injectable({ providedIn: 'root' })
export class SecurityService {

  constructor(private tokenService: TokenService,
              private router: Router) {
  }

  isAuthorized(): boolean {
    return this.tokenService.hasValidToken();
  }

  logout() {
    this.tokenService.clear();
    if (this.router.url === '/') {
      location.reload();
    } else {
      this.router.navigateByUrl("/");
    }
  }

}
