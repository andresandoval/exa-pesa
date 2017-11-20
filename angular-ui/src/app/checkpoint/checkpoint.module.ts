import {NgModule} from "@angular/core";
import {LogbookListComponent} from "./logbook-list/logbook-list.component";
import {LogbookDetailComponent} from "./logbook-detail/logbook-detail.component";
import {routing} from "./checkpoint.route";
import {CheckInDetailComponent} from './check-in-detail/check-in-detail.component';
import {CheckInListComponent} from './check-in-list/check-in-list.component';
import {CheckpointService} from './checkpoint.service';
import {ExaMaterialModule} from "../core/exa-modules/exa-material.module";
import {ExaFormsModule} from "../core/exa-modules/exa-forms.module";
import {CoreModule} from "../core/core.module";
import {CommonModule} from "@angular/common";
import {ExaDialogModule} from "../core/exa-modules/exa-dialog.module";
import {MatCheckboxModule, MatChipsModule, MatPaginatorModule, MatTooltipModule} from "@angular/material";
import {ExaCommonModule} from "../core/exa-modules/exa-common.module";
import {LogbookOutComponent} from './logbook-out/logbook-out.component';
import {CheckInOutputListComponent} from "./check-in-list/check-in-output-list/check-in-output-list.component";
import {CheckInInputListComponent} from "./check-in-list/check-in-input-list/check-in-input-list.component";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {ExaHttpInterceptorService} from "../core/exa-services/exa-http/exa-http-interceptor.service";

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
  declarations: [LogbookListComponent, LogbookDetailComponent, CheckInDetailComponent, CheckInListComponent,
    LogbookOutComponent, CheckInInputListComponent, CheckInOutputListComponent],
  providers: [CheckpointService, {
    provide: HTTP_INTERCEPTORS,
    useClass: ExaHttpInterceptorService,
    multi: true
  }]
})
export class CheckpointModule {
}
