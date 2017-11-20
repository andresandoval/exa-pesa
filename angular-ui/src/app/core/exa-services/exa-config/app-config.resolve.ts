import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from "@angular/router";
import {AppConfig} from "../../../model/core/app-config";
import {AppConfigService} from "./app-config.service";
import {Injectable} from "@angular/core";

@Injectable()
export class AppConfigResolve implements Resolve<AppConfig> {

  constructor(private appConfigService: AppConfigService, private router: Router) {
  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Promise<AppConfig> {

    return this.appConfigService.loadAppConfig()
      .then(es => {
        this.appConfigService.setAppConfig(es);
        return this.appConfigService.appConfig;
      }, error => {
        console.log(error);
        return null;
      });
  }

}
