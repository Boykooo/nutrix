import { NgModule }           from "@angular/core";
import { BlogRoutingModule }  from "./blog-routing.module";
import { NavbarModule }       from "../navbar/navbar.module";
import { NavbarOutletModule } from "../../shared/modules/navbar-outlet.module";

@NgModule({
  declarations: [
  ],
  imports: [
    BlogRoutingModule,
    NavbarOutletModule
  ]
})
export class BlogModule {
}
