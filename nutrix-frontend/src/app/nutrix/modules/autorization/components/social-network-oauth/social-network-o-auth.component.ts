import { Component, OnInit } from '@angular/core';
import { SocialNetworkAuthService } from "../../service/social-network-auth-service";

@Component({
  selector: 'app-social-network-o-auth',
  templateUrl: './social-network-o-auth.component.html',
  styleUrls: ['./social-network-o-auth.component.sass']
})
export class SocialNetworkOAuthComponent implements OnInit {

  loading = true;
  isNewUser = false;

  constructor(private socialNetworkRedirectService: SocialNetworkAuthService) {
  }

  ngOnInit() {
    this.socialNetworkRedirectService.process()
      .subscribe(res => {
        this.loading = false;
        this.isNewUser = res.isNewUser;
      })
  }

}
