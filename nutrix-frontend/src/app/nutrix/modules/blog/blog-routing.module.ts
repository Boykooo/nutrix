import { NgModule }              from "@angular/core";
import { RouterModule, Routes }  from "@angular/router";
import { NavbarOutletComponent } from "../navbar/components/navbar-outlet/navbar-outlet.component";
//import { BlogComponent }         from "/components/blog/blog.component";

const routes: Routes = [
  /*{
    path: 'blog',
    component: NavbarOutletComponent,
    children: [{ path: '', component: BlogComponent }]
  }*/
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogRoutingModule {
}
