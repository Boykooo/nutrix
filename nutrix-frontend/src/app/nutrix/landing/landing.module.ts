import { NgModule }         from "@angular/core";
import { WelcomeComponent } from "./components/welcome/welcome.component";
import { AboutComponent }   from './components/about/about.component';
import { PricingComponent } from './components/pricing/pricing.component';

@NgModule({
  declarations: [
    WelcomeComponent,
    AboutComponent,
    PricingComponent
  ]
})
export class LandingModule {
}
