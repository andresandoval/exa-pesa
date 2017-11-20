import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {LoginComponent} from "./login/login.component";
import {MainComponent} from "./main/main.component";
import {HomeComponent} from "./home/home.component";

const routes : Routes = [
  {path: '', component: MainComponent, children: [
    {path: '', component: HomeComponent},
    {path: 'checkpoint', loadChildren: '../checkpoint/checkpoint.module#CheckpointModule'}
  ]},
  {path: 'login', component: LoginComponent}
];

export const routing : ModuleWithProviders = RouterModule.forChild(routes);
