import { Injectable }   from "@angular/core";
import { TokenService } from "./token.service";
import { RegisterData } from "./entity/register-data";
import { HttpClient }   from "@angular/common/http";
import { Observable }   from "rxjs";
import { TokenHolder }  from "./entity/token-holder";
import { environment }  from "../../../environments/environment";
import { Credentials }  from "./entity/credentials";
import { tap }          from "rxjs/operators";

@Injectable({ providedIn: 'root' })
export class AuthService {

  private readonly url: string = `${environment.api.url}/auth`;

  constructor(private http: HttpClient,
              private tokenService: TokenService) {
  }

  isAuthorized(): boolean {
    return this.tokenService.hasValidToken();
  }

  register(registerData: RegisterData): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/register`, registerData)
      .pipe(tap(th => this.tokenService.save(th)))
  }

  login(credentials: Credentials): Observable<TokenHolder> {
    return this.http.post<TokenHolder>(`${this.url}/email`, credentials)
      .pipe(tap(th => this.tokenService.save(th)));
  }



}
