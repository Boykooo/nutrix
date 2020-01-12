import { Component, OnInit }        from '@angular/core';
import { SocialNetworkAuthService } from "../../service/social-network-auth-service";
import { AccountService }           from "../../../../shared/service/account.service";

@Component({
  selector: 'app-social-network-o-auth-receiver',
  templateUrl: './social-network-o-auth-receiver.component.html',
  styleUrls: ['./social-network-o-auth-receiver.component.sass']
})
export class SocialNetworkOAuthReceiverComponent implements OnInit {

  loading = true;
  isNewUser = false;

  constructor(private socialNetworkRedirectService: SocialNetworkAuthService,
              private accountService: AccountService) {
  }

  ngOnInit() {
    this.socialNetworkRedirectService.process()
      .subscribe(res => {
        this.loading = false;
        this.isNewUser = res.isNewUser;
      })
  }

  updateName() {

  }

}
