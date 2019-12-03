import { NgModule }            from "@angular/core";
import { NavbarComponent }     from "./components/navbar/navbar.component";
import { BaseLayoutModule }    from "../../shared/base-layout.module";
import { RouterModule }        from "@angular/router";
import { AuthorizationModule } from "../autorization/authorization.module";

@NgModule({
  declarations: [
    NavbarComponent
  ],
  imports: [
    BaseLayoutModule,
    RouterModule.forChild([]),
    AuthorizationModule
  ],
  exports: [
    NavbarComponent
  ]
})
export class NavbarModule {
}
