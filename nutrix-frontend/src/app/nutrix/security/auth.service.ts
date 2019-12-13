import { Injectable }                        from "@angular/core";
import { TokenService }                      from "./token.service";
import { RegisterData }                      from "./entity/register-data";
import { HttpClient }                        from "@angular/common/http";
import { Observable }                        from "rxjs";
import { TokenHolder }                       from "./entity/token-holder";
import { environment }                       from "../../../environments/environment";
import { Credentials }                       from "./entity/credentials";
import { tap }                               from "rxjs/operators";
import { Router }                            from "@angular/router";
import { SocialNetworkAuthenticationResult } from "./entity/social-network-authentication-result";
import { SocialNetworkAuthenticationParams } from "../modules/autorization/entity/social-network-authentication-params";

@Injectable({ providedIn: 'root' })
export class AuthService {

  private readonly url: string = `${environment.api.url}/auth`;

  constructor(private http: HttpClient,
              private tokenService: TokenService,
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

  register(registerData: RegisterData): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/register`, registerData)
      .pipe(tap(th => this.tokenService.save(th)))
  }

  login(credentials: Credentials): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/email`, credentials)
      .pipe(tap(th => this.tokenService.save(th)));
  }

  socialNetworkLogin(params: SocialNetworkAuthenticationParams): Observable<SocialNetworkAuthenticationResult> {
    return this.http.post<SocialNetworkAuthenticationResult>(`${this.url}/social`, params)
      .pipe(tap(th => this.tokenService.save(th)));
  }

}
