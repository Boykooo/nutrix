import { AppComponent } from './initial/app.component';
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { RouterModule } from "@angular/router";
import { NutrixModule } from "./nutrix/nutrix.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([]),
    NutrixModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
