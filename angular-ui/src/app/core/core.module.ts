import {NgModule} from "@angular/core";
import {ExaHttpService} from "./exa-services/exa-http/exa-http.service";
import {ExaTokenService} from "./exa-services/exa-security/exa-token.service";
import {ExaHttpInterceptorService} from "./exa-services/exa-http/exa-http-interceptor.service";
import {LeadingZerosPipe} from "./exa-pipes/leading-zeros.pipe";
import {HttpClientModule} from "@angular/common/http";
import {ExaDialogService} from "./exa-services/exa-dialog/exa-dialog.service";

@NgModule({
  imports: [
    HttpClientModule
  ],
  providers: [
    ExaHttpService,
    ExaTokenService,
    ExaHttpInterceptorService,
    ExaDialogService]
})
export class CoreModule {
}
