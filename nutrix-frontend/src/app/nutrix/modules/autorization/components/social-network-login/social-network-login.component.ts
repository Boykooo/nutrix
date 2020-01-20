import { Component, OnInit }  from '@angular/core';
import { GoogleOAuthService } from "../../service/oauth/google-o-auth.service";

@Component({
  selector: 'app-social-network-login',
  templateUrl: './social-network-login.component.html',
  styleUrls: ['./social-network-login.component.sass']
})
export class SocialNetworkLoginComponent implements OnInit {

  constructor(private googleAuthService: GoogleOAuthService) { }

  ngOnInit() {
  }

  google() {
    this.googleAuthService.auth();
  }

}
