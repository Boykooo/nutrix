import { NgModule }                         from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule }          from "@angular/platform-browser/animations";
import { BrowserModule }                    from "@angular/platform-browser";
import { FlexLayoutModule }                 from "@angular/flex-layout";

@NgModule({
  exports: [
    FormsModule,
    BrowserModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ]
})
export class BaseLayoutModule {
}
