import {NgModule} from '@angular/core';
import {HighlightPipe} from '../exa-pipes/highlight.pipe';
import {LeadingZerosPipe} from "../exa-pipes/leading-zeros.pipe";

@NgModule({
  imports: [],
  declarations: [LeadingZerosPipe, HighlightPipe],
  exports: [LeadingZerosPipe, HighlightPipe]
})
export class ExaCommonModule {
}
