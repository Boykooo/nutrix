import { Component, OnInit } from '@angular/core';
import { GoogleAuthService } from "../../service/google-auth.service";

@Component({
  selector: 'app-social-network-login',
  templateUrl: './social-network-login.component.html',
  styleUrls: ['./social-network-login.component.sass']
})
export class SocialNetworkLoginComponent implements OnInit {

  constructor(private googleAuthService: GoogleAuthService) { }

  ngOnInit() {
  }

  google() {
    this.googleAuthService.auth();
  }

}
