import { NgModule } from "@angular/core";
import { SignInComponent } from "./components/sign-in/sign-in.component";
import { AuthorizationRoutingModule } from "./authorization-routing.module";
import { BaseLayoutModule } from "../../shared/modules/base-layout.module";
import { SignWrapperComponent } from './components/sign-wrapper/sign-wrapper.component';
import { SocialNetworkLoginComponent } from './components/social-network-login/social-network-login.component';
import { MatIconModule } from "@angular/material/icon";
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatInputModule } from "@angular/material/input";
import { SocialNetworkOAuthReceiverComponent } from "./components/social-network-oauth-receiver/social-network-o-auth-receiver.component";
import { CreateAccountComponent } from "./components/sign-up/create-account/create-account.component";
import { SignUpComponent } from './components/sign-up/sign-up/sign-up.component';
import { MatTabsModule } from "@angular/material/tabs";
import { MatStepperModule } from "@angular/material/stepper";
import { WeightStepComponent } from './components/sign-up/weight-step/weight-step.component';

@NgModule({
  declarations: [
    SignWrapperComponent,
    SignInComponent,
    CreateAccountComponent,
    SocialNetworkLoginComponent,
    SocialNetworkOAuthReceiverComponent,
    SignUpComponent,
    WeightStepComponent,
  ],
  imports: [
    BaseLayoutModule,
    AuthorizationRoutingModule,
    MatIconModule,
    MatCheckboxModule,
    MatInputModule,
    MatTabsModule,
    MatStepperModule
  ]
})
export class AuthorizationModule {
}

