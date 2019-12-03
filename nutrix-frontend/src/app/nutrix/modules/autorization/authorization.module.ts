import { NgModule }                   from "@angular/core";
import { SignInComponent }            from "./components/sign-in/sign-in.component";
import { SignUpComponent }            from "./components/sign-up/sign-up.component";
import { AuthorizationRoutingModule } from "./authorization-routing.module";
import { BaseLayoutModule }           from "../../shared/base-layout.module";
import { SignWrapperComponent }       from './components/sign-wrapper/sign-wrapper.component';
import { SocialNetworkLoginComponent } from './components/social-network-login/social-network-login.component';

@NgModule({
  declarations: [
    SignWrapperComponent,
    SignInComponent,
    SignUpComponent,
    SocialNetworkLoginComponent
  ],
  imports: [
    BaseLayoutModule,
    AuthorizationRoutingModule
  ]
})
export class AuthorizationModule {
}
