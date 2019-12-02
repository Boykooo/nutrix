import { NgModule }         from "@angular/core";
import { WelcomeComponent } from "./components/welcome/welcome.component";
import { AboutComponent }   from './components/about/about.component';
import { PricingComponent } from './components/pricing/pricing.component';
import { BaseLayoutModule } from "../shared/modules/base-layout.module";

@NgModule({
  declarations: [
    WelcomeComponent,
    AboutComponent,
    PricingComponent
  ],
  imports: [
    BaseLayoutModule
  ]
})
export class LandingModule {
}
