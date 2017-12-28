import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {LogbookListComponent} from "./logbook/logbook-list/logbook-list.component";
import {LogbookInputNewComponent} from "./logbook/logbook-input-new/logbook-input-new.component";
import {CheckInListComponent} from "./check-in/check-in-list/check-in-list.component";
import {CheckInDetailComponent} from "./check-in/check-in-detail/check-in-detail.component";
import {LogbookOutRegisterComponent} from "./logbook/logbook-output-register/logbook-out-register.component";
import {CheckInInputListComponent} from "./check-in/check-in-list/check-in-input-list/check-in-input-list.component";
import {CheckInOutputListComponent} from "./check-in/check-in-list/check-in-output-list/check-in-output-list.component";
import {LogbookOutputNewComponent} from "./logbook/logbook-output-new/logbook-output-new.component";

const routes: Routes = [
  {path: 'logbook', component: LogbookListComponent},
  {path: 'logbook/input', component: LogbookInputNewComponent},
  {path: 'logbook/output', component: LogbookOutputNewComponent},
  {path: 'logbook/output/:id', component: LogbookOutRegisterComponent},
  {
    path: 'check-in', component: CheckInListComponent, children: [
      {path: '', pathMatch: 'full', redirectTo: 'input'},
      {path: 'input', component: CheckInInputListComponent},
      {path: 'output', component: CheckInOutputListComponent}
    ]
  },
  {path: 'check-in/input/new', component: CheckInDetailComponent},
  {path: 'check-in/input/edit/:id', component: CheckInDetailComponent},
  {path: '**', redirectTo: ''}
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
