import { NutrixRoutingModule } from "./nutrix-routing.module";
import { WelcomeComponent } from './landing/welcome/welcome.component';
import { NgModule } from "@angular/core";

@NgModule({
  declarations: [WelcomeComponent],
  imports: [
    NutrixRoutingModule
  ]
})
export class NutrixModule {
}
