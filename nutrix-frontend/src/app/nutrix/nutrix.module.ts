import { NutrixRoutingModule } from "./nutrix-routing.module";
import { WelcomeComponent }    from './landing/welcome/welcome.component';
import { NgModule }            from "@angular/core";
import { HttpClientModule }    from "@angular/common/http";

@NgModule({
  declarations: [WelcomeComponent],
  imports: [
    NutrixRoutingModule,
    HttpClientModule
  ]
})
export class NutrixModule {
}
