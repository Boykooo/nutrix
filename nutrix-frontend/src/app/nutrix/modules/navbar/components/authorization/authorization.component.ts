import { Component, OnInit } from '@angular/core';
import { LoginService }      from "../../../autorization/service/login.service";
import { SecurityService }   from "../../../../security/security.service";

@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.sass']
})
export class AuthorizationComponent implements OnInit {

  isAuthorized: boolean;

  constructor(private securityService: SecurityService) {
    this.isAuthorized = securityService.isAuthorized();
  }

  ngOnInit() {
  }

  logout() {
    this.securityService.logout();
  }


}
