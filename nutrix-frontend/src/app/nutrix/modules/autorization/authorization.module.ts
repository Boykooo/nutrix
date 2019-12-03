import { NgModule }                   from "@angular/core";
import { AuthorizationComponent }     from "./components/authorization/authorization.component";
import { SignInComponent }            from "./components/sign-in/sign-in.component";
import { SignUpComponent }            from "./components/sign-up/sign-up.component";
import { AuthorizationRoutingModule } from "./authorization-routing.module";
import { BaseLayoutModule }           from "../../shared/base-layout.module";

@NgModule({
  declarations: [
    AuthorizationComponent,
    SignInComponent,
    SignUpComponent
  ],
  imports: [
    BaseLayoutModule,
    AuthorizationRoutingModule
  ],
  exports: [
    AuthorizationComponent
  ]
})
export class AuthorizationModule {

}
