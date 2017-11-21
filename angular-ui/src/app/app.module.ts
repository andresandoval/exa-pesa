import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";

import {AppComponent} from "./app.component";
import {routing} from "./app.route";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatIconModule} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";
import {ViewportStateService} from "./core/exa-services/exa-viewport/viewport-state.service";


@NgModule({
  declarations: [
    AppComponent
  ],
  providers: [ViewportStateService],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatIconModule,
    FlexLayoutModule,
    routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
