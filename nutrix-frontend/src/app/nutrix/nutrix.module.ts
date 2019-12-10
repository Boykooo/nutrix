import { NutrixRoutingModule } from "./nutrix-routing.module";
import { NgModule }            from "@angular/core";
import { LandingModule }       from "./modules/landing/landing.module";
import { DashboardModule }     from "./modules/dashboard/dashboard.module";
import { BlogModule }          from "./modules/blog/blog.module";
import { HttpTranslateModule } from "./shared/modules/http-translate.module";
import { AuthorizationModule } from "./modules/autorization/authorization.module";
import { HttpClientModule }    from "@angular/common/http";
import { CookieService }       from "ngx-cookie-service";
import { TranslateService }    from "@ngx-translate/core";

@NgModule({
  imports: [
    NutrixRoutingModule,
    AuthorizationModule,
    LandingModule,
    DashboardModule,
    BlogModule,
    HttpTranslateModule,
    HttpClientModule,
  ],
  providers: [CookieService]
})
export class NutrixModule {

  constructor(private translateService: TranslateService) {
    translateService.use('ru');
  }

}

