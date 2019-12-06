import { Component, OnInit } from '@angular/core';
import { AuthService }       from "../../../../security/auth.service";

@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.sass']
})
export class AuthorizationComponent implements OnInit {

  isAuthorized: boolean;

  constructor(private authService: AuthService) {
    this.isAuthorized = authService.isAuthorized();
  }

  ngOnInit() {
  }

}
