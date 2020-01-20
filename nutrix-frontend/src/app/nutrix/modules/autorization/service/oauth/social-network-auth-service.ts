import { Injectable }                             from "@angular/core";
import { ActivatedRoute, ActivatedRouteSnapshot } from "@angular/router";
import { SocialNetworkType }                      from "../../entity/social-network-type";
import { SocialNetworkAuthenticationParams }      from "../../entity/social-network-authentication-params";
import { Observable }                             from "rxjs";
import { TokenHolder }                            from "../../../../security/entity/token-holder";
import { LoginService }                           from "../login.service";
import { SignUpProgressService }                  from "../sign-up-progress.service";

@Injectable({ providedIn: 'root' })
export class SocialNetworkAuthService {

  private readonly socialNetworkProcessMap = new Map([
    [SocialNetworkType.GOOGLE, (snapshot: ActivatedRouteSnapshot) => this.processGoogle(snapshot)]
  ]);

  constructor(private route: ActivatedRoute,
              private loginService: LoginService,
              private signUpProgressService: SignUpProgressService) {
  }

  process(): Observable<TokenHolder> {
    let snapshot = this.route.snapshot;
    let socialType = snapshot.queryParamMap.get('state');
    let processStrategy = this.socialNetworkProcessMap.get(SocialNetworkType[socialType]);
    return processStrategy(snapshot);
  }

  private processGoogle(snapshot: ActivatedRouteSnapshot): Observable<TokenHolder> {
    let queryParamMap = snapshot.queryParamMap;
    let params: SocialNetworkAuthenticationParams = {
      code: queryParamMap.get('code'),
      redirectUri: this.getCurrentUri(),
      socialNetworkType: SocialNetworkType.GOOGLE,
      physicalData: this.signUpProgressService.getProgress()
    };
    return this.loginService.socialNetworkLogin(params);
  }

  getCurrentUri(): string {
    return window.location.href.split('?')[0];
  }

}
