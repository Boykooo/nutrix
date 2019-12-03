import { NgModule }           from "@angular/core";
import { BlogComponent }      from './components/blog/blog.component';
import { BlogRoutingModule }  from "./blog-routing.module";
import { NavbarModule }       from "../navbar/navbar.module";
import { NavbarOutletModule } from "../../shared/navbar-outlet.module";

@NgModule({
  declarations: [
    BlogComponent
  ],
  imports: [
    BlogRoutingModule,
    NavbarOutletModule
  ]
})
export class BlogModule {
}
