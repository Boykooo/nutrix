import { Injectable }                        from "@angular/core";
import { environment }                       from "../../../../../environments/environment";
import { HttpClient }                        from "@angular/common/http";
import { TokenService }                      from "../../../security/token.service";
import { Observable }                        from "rxjs";
import { TokenHolder }                       from "../../../security/entity/token-holder";
import { tap }                               from "rxjs/operators";
import { Credentials }                       from "../entity/credentials";
import { SocialNetworkAuthenticationParams } from "../entity/social-network-authentication-params";
import { CredentialsRegisterData }           from "../entity/credentials-register-data";

@Injectable({ providedIn: 'root' })
export class LoginService {

  private readonly url: string = `${environment.api.url}/auth`;

  constructor(private http: HttpClient,
              private tokenService: TokenService) {
  }

  register(registerData: CredentialsRegisterData): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/register`, registerData)
      .pipe(tap(th => this.tokenService.save(th)))
  }

  login(credentials: Credentials): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/email`, credentials)
      .pipe(tap(th => this.tokenService.save(th)));
  }

  socialNetworkLogin(params: SocialNetworkAuthenticationParams): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/social`, params)
      .pipe(tap(th => this.tokenService.save(th)));
  }

}
