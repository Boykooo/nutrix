import { Injectable } from "@angular/core";
import { ActivatedRoute, ActivatedRouteSnapshot } from "@angular/router";
import { SocialNetworkType } from "../entity/social-network-type";
import { AuthService } from "../../../security/auth.service";
import { SocialNetworkAuthenticationParams } from "../entity/social-network-authentication-params";
import { Observable } from "rxjs";
import { SocialNetworkAuthenticationResult } from "../../../security/entity/social-network-authentication-result";

@Injectable({providedIn: 'root'})
export class SocialNetworkAuthService {

  private readonly socialNetworkProcessMap = new Map([
    [SocialNetworkType.GOOGLE, (snapshot: ActivatedRouteSnapshot) => this.processGoogle(snapshot)]
  ]);

  constructor(private route: ActivatedRoute,
              private authService: AuthService) {
  }

  process(): Observable<SocialNetworkAuthenticationResult> {
    let snapshot = this.route.snapshot;
    let socialType = snapshot.queryParamMap.get('state');
    let processStrategy = this.socialNetworkProcessMap.get(SocialNetworkType[socialType]);
    return processStrategy(snapshot);
  }

  private processGoogle(snapshot: ActivatedRouteSnapshot): Observable<SocialNetworkAuthenticationResult> {
    let queryParamMap = snapshot.queryParamMap;
    let params: SocialNetworkAuthenticationParams = {
      code: queryParamMap.get('code'),
      redirectUri: this.getCurrentUri(),
      socialNetworkType: SocialNetworkType.GOOGLE
    };
    return this.authService.socialNetworkLogin(params);
  }

  getCurrentUri(): string {
    return window.location.href.split('?')[0];
  }

}
