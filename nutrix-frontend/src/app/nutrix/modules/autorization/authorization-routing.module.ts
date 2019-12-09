import { RouterModule, Routes }  from "@angular/router";
import { NavbarOutletComponent } from "../navbar/components/navbar-outlet/navbar-outlet.component";
import { SignUpComponent }       from "./components/sign-up/sign-up.component";
import { NgModule }              from "@angular/core";
import { SignInComponent }       from "./components/sign-in/sign-in.component";
import { SignWrapperComponent }  from "./components/sign-wrapper/sign-wrapper.component";
import { SocialNetworkOAuthComponent } from "./components/social-network-oauth/social-network-o-auth.component";

const routes: Routes = [
  {
    path: 'signup',
    component: NavbarOutletComponent,
    children: [
      {
        path: '',
        component: SignWrapperComponent,
        children: [{ path: '', component: SignUpComponent }]
      }
    ]
  },
  {
    path: 'signin',
    component: NavbarOutletComponent,
    children: [{ path: '', component: SignInComponent }]
  },
  {
    path: 'login/oauth',
    component: SocialNetworkOAuthComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthorizationRoutingModule {
}
