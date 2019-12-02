import { NutrixRoutingModule } from "./nutrix-routing.module";
import { NgModule }            from "@angular/core";
import { LandingModule }       from "./modules/landing/landing.module";
import { DashboardModule }     from "./modules/dashboard/dashboard.module";
import { BlogModule }          from "./modules/blog/blog.module";
import { SharedModule }        from "./shared/shared.module";
import { HttpTranslateModule } from "./shared/modules/http-translate.module";

@NgModule({
  imports: [
    NutrixRoutingModule,
    SharedModule,
    LandingModule,
    DashboardModule,
    BlogModule,
    HttpTranslateModule
  ]
})
export class NutrixModule {
}

