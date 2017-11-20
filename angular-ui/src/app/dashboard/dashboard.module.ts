import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {LoginComponent} from "./login/login.component";
import {routing} from "./dashboard.route";
import {MainComponent} from "./main/main.component";
import {ExaMaterialModule} from "../core/exa-modules/exa-material.module";
import {ExaFormsModule} from "../core/exa-modules/exa-forms.module";
import {MenuComponent} from "./menu/menu.component";
import {HomeComponent} from './home/home.component';
import {DashboardService} from './dashboard.service';
import {ExaDialogModule} from "../core/exa-modules/exa-dialog.module";
import {CoreModule} from "../core/core.module";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {ExaHttpInterceptorService} from "../core/exa-services/exa-http/exa-http-interceptor.service";

@NgModule({
  imports: [
    CommonModule,
    ExaMaterialModule,
    ExaFormsModule,
    ExaDialogModule,
    CoreModule,
    routing
  ],
  declarations: [LoginComponent, MainComponent, MenuComponent, HomeComponent],
  providers: [DashboardService, {
    provide: HTTP_INTERCEPTORS,
    useClass: ExaHttpInterceptorService,
    multi: true
  }]
})
export class DashboardModule { }
