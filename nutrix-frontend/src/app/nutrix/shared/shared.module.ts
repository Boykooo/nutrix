import { NgModule }              from "@angular/core";
import { NavbarComponent }       from "./components/navbar/navbar.component";
import { NavbarOutletComponent } from "./components/navbar-outlet/navbar-outlet.component";
import { RouterModule }          from "@angular/router";

@NgModule({
  declarations: [
    NavbarComponent,
    NavbarOutletComponent
  ],
  imports: [
    RouterModule.forChild([])
  ]
})
export class SharedModule {
}
