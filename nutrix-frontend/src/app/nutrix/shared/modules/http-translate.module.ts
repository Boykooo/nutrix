import { NgModule }                         from "@angular/core";
import { HttpClient }                       from "@angular/common/http";
import { TranslateLoader, TranslateModule } from "@ngx-translate/core";
import { MultiTranslateHttpLoader }         from "ngx-translate-multi-http-loader";

@NgModule({
  imports: [
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  exports: [
    TranslateModule
  ]
})
export class HttpTranslateModule {
}

export function HttpLoaderFactory(http: HttpClient) {
  return new MultiTranslateHttpLoader(http, [
    { prefix: './assets/i18n/', suffix: '.json' },
    { prefix: './assets/i18n/errors/', suffix: '.json' },
    { prefix: './assets/i18n/navbar/', suffix: '.json' },
    { prefix: './assets/i18n/login/login/', suffix: '.json' },
    { prefix: './assets/i18n/login/register/', suffix: '.json' },
  ])
}
