import { NgModule }              from "@angular/core";
import { NavbarModule }          from "../modules/navbar/navbar.module";
import { NavbarOutletComponent } from "../modules/navbar/components/navbar-outlet/navbar-outlet.component";
import { RouterModule }          from "@angular/router";

@NgModule({
  declarations: [
    NavbarOutletComponent
  ],
  imports: [
    NavbarModule,
    RouterModule.forChild([])
  ]
})
export class NavbarOutletModule {
}
