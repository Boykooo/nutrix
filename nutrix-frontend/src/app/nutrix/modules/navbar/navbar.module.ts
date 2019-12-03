import { NgModule }               from "@angular/core";
import { NavbarComponent }        from "./components/navbar/navbar.component";
import { BaseLayoutModule }       from "../../shared/base-layout.module";
import { RouterModule }           from "@angular/router";
import { AuthorizationComponent } from "./components/authorization/authorization.component";

@NgModule({
  declarations: [
    AuthorizationComponent,
    NavbarComponent
  ],
  imports: [
    BaseLayoutModule,
    RouterModule.forChild([])
  ],
  exports: [
    NavbarComponent
  ]
})
export class NavbarModule {
}
