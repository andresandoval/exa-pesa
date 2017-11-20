import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {AppConfigResolve} from "./core/exa-services/exa-config/app-config.resolve";

const routes: Routes = [
  {path: '', loadChildren: './dashboard/dashboard.module#DashboardModule', resolve: {appConfig: AppConfigResolve}}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
