import {NgModule} from '@angular/core';
import {AppConfigService} from '../exa-services/exa-config/app-config.service';
import {AppConfigResolve} from "../exa-services/exa-config/app-config.resolve";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [AppConfigService, AppConfigResolve]
})
export class ExaConfigModule {
}
