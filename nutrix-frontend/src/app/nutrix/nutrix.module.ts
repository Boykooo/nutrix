import { NutrixRoutingModule } from "./nutrix-routing.module";
import { NgModule }            from "@angular/core";
import { LandingModule }       from "./landing/landing.module";
import { DashboardModule }     from "./dashboard/dashboard.module";
import { BlogModule }          from "./blog/blog.module";

@NgModule({
  declarations: [],
  imports: [
    NutrixRoutingModule,
    LandingModule,
    DashboardModule,
    BlogModule
  ]
})
export class NutrixModule {
}
