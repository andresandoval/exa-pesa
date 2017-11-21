import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {LogbookListComponent} from "./logbook-list/logbook-list.component";
import {LogbookDetailComponent} from "./logbook-detail/logbook-detail.component";
import {CheckInListComponent} from "./check-in-list/check-in-list.component";
import {CheckInDetailComponent} from "./check-in-detail/check-in-detail.component";
import {LogbookOutComponent} from "./logbook-out/logbook-out.component";
import {CheckInInputListComponent} from "./check-in-list/check-in-input-list/check-in-input-list.component";
import {CheckInOutputListComponent} from "./check-in-list/check-in-output-list/check-in-output-list.component";

const routes: Routes = [
  {path: 'logbook', component: LogbookListComponent},
  {path: 'logbook/new', component: LogbookDetailComponent},
  {path: 'logbook/edit', component: LogbookDetailComponent},
  {path: 'logbook/out/:id', component: LogbookOutComponent},
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
