import { NgModule }               from "@angular/core";
import { NavbarComponent }        from "./components/navbar/navbar.component";
import { RouterModule }           from "@angular/router";
import { AuthorizationComponent } from "./components/authorization/authorization.component";
import { BaseLayoutModule }       from "../../shared/modules/base-layout.module";

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
