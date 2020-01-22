import { NutrixRoutingModule }                 from "./nutrix-routing.module";
import { NgModule }                            from "@angular/core";
import { LandingModule }                       from "./modules/landing/landing.module";
import { DashboardModule }                     from "./modules/dashboard/dashboard.module";
import { BlogModule }                          from "./modules/blog/blog.module";
import { HttpTranslateModule }                 from "./shared/modules/http-translate.module";
import { AuthorizationModule }                 from "./modules/autorization/authorization.module";
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { CookieService }                       from "ngx-cookie-service";
import { TranslateService }                    from "@ngx-translate/core";
import { JwtInterceptor }                      from "./security/jwt.interceptor";

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
  providers: [
    CookieService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }
  ]
})
export class NutrixModule {

  constructor(private translateService: TranslateService) {
    translateService.use('en');
  }

}

