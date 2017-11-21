import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

const routes: Routes = [
  {path: '', loadChildren: './dashboard/dashboard.module#DashboardModule'}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
