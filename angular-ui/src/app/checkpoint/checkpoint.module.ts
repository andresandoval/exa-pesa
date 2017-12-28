import {NgModule} from "@angular/core";
import {LogbookListComponent} from "./logbook/logbook-list/logbook-list.component";
import {routing} from "./checkpoint.route";
import {CheckInDetailComponent} from './check-in/check-in-detail/check-in-detail.component';
import {CheckInListComponent} from './check-in/check-in-list/check-in-list.component';
import {CheckpointService} from './checkpoint.service';
import {ExaMaterialModule} from "../core/exa-modules/exa-material.module";
import {ExaFormsModule} from "../core/exa-modules/exa-forms.module";
import {CoreModule} from "../core/core.module";
import {CommonModule} from "@angular/common";
import {ExaDialogModule} from "../core/exa-modules/exa-dialog.module";
import {MatCheckboxModule, MatChipsModule, MatPaginatorModule, MatTooltipModule} from "@angular/material";
import {ExaCommonModule} from "../core/exa-modules/exa-common.module";
import {LogbookOutRegisterComponent} from './logbook/logbook-output-register/logbook-out-register.component';
import {CheckInOutputListComponent} from "./check-in/check-in-list/check-in-output-list/check-in-output-list.component";
import {CheckInInputListComponent} from "./check-in/check-in-list/check-in-input-list/check-in-input-list.component";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {ExaHttpInterceptorService} from "../core/exa-services/exa-http/exa-http-interceptor.service";
import {LogbookSelectorComponent} from './logbook/logbook-selector/logbook-selector.component';
import {LogbookOutputNewComponent} from './logbook/logbook-output-new/logbook-output-new.component';
import {LogbookInputNewComponent} from "./logbook/logbook-input-new/logbook-input-new.component";

@NgModule({
  imports: [
    routing,
    CommonModule,
    ExaMaterialModule,
    ExaFormsModule,
    ExaDialogModule,
    CoreModule,
    MatPaginatorModule,
    MatTooltipModule,
    MatChipsModule,
    MatCheckboxModule,
    ExaCommonModule
  ],
  declarations: [LogbookListComponent,
    CheckInDetailComponent,
    CheckInListComponent,
    LogbookOutRegisterComponent,
    CheckInInputListComponent,
    CheckInOutputListComponent,
    LogbookInputNewComponent,
    LogbookSelectorComponent,
    LogbookOutputNewComponent],
  entryComponents: [LogbookSelectorComponent],
  providers: [CheckpointService, {
    provide: HTTP_INTERCEPTORS,
    useClass: ExaHttpInterceptorService,
    multi: true
  }]
})
export class CheckpointModule {
}
