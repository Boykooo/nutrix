import { NgModule }              from "@angular/core";
import { Route, RouterModule }   from "@angular/router";
import { WelcomeComponent }      from "./modules/landing/components/welcome/welcome.component";
import { NavbarOutletComponent } from "./modules/navbar/components/navbar-outlet/navbar-outlet.component";

const routes: Route[] = [
  {
    path: '',
    pathMatch: 'full',
    component: NavbarOutletComponent,
    children: [{ path: '', component: WelcomeComponent }]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NutrixRoutingModule {
}

