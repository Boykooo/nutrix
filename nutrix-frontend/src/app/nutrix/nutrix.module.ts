import { NutrixRoutingModule } from "./nutrix-routing.module";
import { NgModule }            from "@angular/core";
import { LandingModule }       from "./modules/landing/landing.module";
import { DashboardModule }     from "./modules/dashboard/dashboard.module";
import { BlogModule }          from "./modules/blog/blog.module";
import { HttpTranslateModule } from "./shared/http-translate.module";

@NgModule({
  imports: [
    NutrixRoutingModule,
    LandingModule,
    DashboardModule,
    BlogModule,
    HttpTranslateModule
  ]
})
export class NutrixModule {
}

