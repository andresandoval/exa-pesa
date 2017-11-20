import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ConfirmationDialogComponent} from "../exa-components/confirmation-dialog/confirmation-dialog.component";
import {SpinnerComponent} from "../exa-components/spinner/spinner.component";
import {MatButtonModule, MatDialogModule, MatProgressSpinnerModule} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";
import { ExaSpinnerService } from '../exa-services/exa-dialog/exa-spinner.service';

@NgModule({
  imports: [
    CommonModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatButtonModule,
    FlexLayoutModule
  ],
  declarations: [SpinnerComponent, ConfirmationDialogComponent],
  entryComponents: [ConfirmationDialogComponent, SpinnerComponent],
  providers: [ExaSpinnerService]
})
export class ExaDialogModule {
}
