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
import { SignUpComponent }           from './components/sign-up/sign-up/sign-up.component';
import { MatTabsModule }             from "@angular/material/tabs";
import { MatStepperModule }                     from "@angular/material/stepper";
import { MatButtonModule }                      from "@angular/material/button";
import { GenderStepComponent }                  from './components/sign-up/gender-step/gender-step.component';
import { GoalStepComponent }                    from "./components/sign-up/goal-step/goal-step.component";
import { PhysicalDataStepComponent }            from './components/sign-up/physical-data-step/physical-data-step.component';
import { MatDatepickerModule }                  from "@angular/material/datepicker";
import { MAT_DATE_LOCALE, MatNativeDateModule } from "@angular/material/core";

@NgModule({
  declarations: [
    SignWrapperComponent,
    SignInComponent,
    CreateAccountComponent,
    SocialNetworkLoginComponent,
    SocialNetworkOAuthReceiverComponent,
    SignUpComponent,
    GoalStepComponent,
    GenderStepComponent,
    PhysicalDataStepComponent,
  ],
  imports: [
    BaseLayoutModule,
    AuthorizationRoutingModule,
    MatIconModule,
    MatCheckboxModule,
    MatInputModule,
    MatTabsModule,
    MatStepperModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
    MatDatepickerModule,
    {provide: MAT_DATE_LOCALE, useValue: 'ru-ru'}
  ]
})
export class AuthorizationModule {
}

