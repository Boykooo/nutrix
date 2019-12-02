import { NutrixRoutingModule }   from "./nutrix-routing.module";
import { NgModule }              from "@angular/core";
import { LandingModule }         from "./landing/landing.module";
import { DashboardModule }       from "./dashboard/dashboard.module";
import { BlogModule }            from "./blog/blog.module";
import { NavbarComponent }       from './shared/components/navbar/navbar.component';
import { NavbarOutletComponent } from './shared/components/navbar-outlet/navbar-outlet.component';
import { SharedModule }          from "./shared/shared.module";

@NgModule({
  imports: [
    NutrixRoutingModule,
    SharedModule,
    LandingModule,
    DashboardModule,
    BlogModule
  ]
})
export class NutrixModule {
}
