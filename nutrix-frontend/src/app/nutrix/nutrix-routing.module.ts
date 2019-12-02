import { NgModule }              from "@angular/core";
import { Route, RouterModule }   from "@angular/router";
import { WelcomeComponent }      from "./landing/components/welcome/welcome.component";
import { NavbarOutletComponent } from "./shared/components/navbar-outlet/navbar-outlet.component";

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

