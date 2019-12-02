import { NgModule }            from "@angular/core";
import { Route, RouterModule } from "@angular/router";
import { WelcomeComponent }    from "./landing/components/welcome/welcome.component";

const routes: Route[] = [
  {
    path: '',
    pathMatch: 'full',
    component: WelcomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NutrixRoutingModule {
}

