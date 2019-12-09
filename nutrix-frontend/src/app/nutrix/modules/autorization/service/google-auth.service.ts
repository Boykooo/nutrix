import { Injectable }  from "@angular/core";
import { environment } from "../../../../../environments/environment";
import { Router }      from "@angular/router";

@Injectable({ providedIn: 'root' })
export class GoogleAuthService {

  private readonly url = `https://accounts.google.com/o/oauth2/v2/auth?` +
    `client_id=${environment.oauth.google.clientId}` +
    `&response_type=code` +
    `&redirect_uri=${environment.oauth.google.redirectUrl}` +
    `&scope=openid%20email`;

  constructor(private router: Router) {
  }


  auth() {
    // let newWindow = window.open(this.url, 'name', 'height=600,width=450');
    // if (window.focus) {
    //   newWindow.focus();
    // }
    location.href = this.url;
  }

}
