import { NgModule }               from "@angular/core";
import { NavbarComponent }        from "./components/navbar/navbar.component";
import { NavbarOutletComponent }  from "./components/navbar-outlet/navbar-outlet.component";
import { RouterModule }           from "@angular/router";
import { BaseLayoutModule }       from "./modules/base-layout.module";
import { AuthorizationComponent } from './components/navbar/authorization/authorization.component';
import { SignInComponent }        from './components/navbar/authorization/sign-in/sign-in.component';
import { SignUpComponent } from './components/navbar/authorization/sign-up/sign-up.component';

@NgModule({
  declarations: [
    NavbarComponent,
    NavbarOutletComponent,
    AuthorizationComponent,
    SignInComponent,
    SignUpComponent
  ],
  imports: [
    BaseLayoutModule,
    RouterModule.forChild([])
  ]
})
export class SharedModule {
}
