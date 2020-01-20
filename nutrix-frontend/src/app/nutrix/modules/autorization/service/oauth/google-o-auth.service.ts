import { Injectable }  from "@angular/core";
import { environment } from "../../../../../../environments/environment";

@Injectable({ providedIn: 'root' })
export class GoogleOAuthService {

  private readonly url = `https://accounts.google.com/o/oauth2/v2/auth?` +
    `client_id=${environment.oauth.google.clientId}` +
    `&response_type=code` +
    `&redirect_uri=${environment.oauth.google.redirectUrl}` +
    `&scope=openid%20email` +
    `&state=GOOGLE`;

  auth() {
    location.href = this.url;
  }

}
