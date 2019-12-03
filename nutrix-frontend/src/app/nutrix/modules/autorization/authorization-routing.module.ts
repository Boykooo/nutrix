import { RouterModule, Routes }  from "@angular/router";
import { NavbarOutletComponent } from "../navbar/components/navbar-outlet/navbar-outlet.component";
import { SignUpComponent }       from "./components/sign-up/sign-up.component";
import { NgModule }              from "@angular/core";

const routes: Routes = [
  {
    path: 'signup',
    component: NavbarOutletComponent,
    children: [{ path: '', component: SignUpComponent }]
  },
  {
    path: 'signup',
    component: NavbarOutletComponent,
    children: [{ path: '', component: SignUpComponent }]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthorizationRoutingModule {
}
