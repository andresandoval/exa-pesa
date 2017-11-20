import {Injectable} from '@angular/core';
import {AppConfig} from "../../../model/core/app-config";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

const appConfigUrl: string = "assets/app-config.json";

@Injectable()
export class AppConfigService {


  public appConfig: AppConfig;
  private appConfigNull: AppConfig = null;
  private appConfigSubject: BehaviorSubject<AppConfig> = new BehaviorSubject<AppConfig>(null);

  constructor(private http: HttpClient) {
  }

  loadAppConfig() {
    if (this.appConfig === null || this.appConfig === undefined) {
      console.log('Loading app-config.json');

      return this.http.get<AppConfig>(appConfigUrl).toPromise<AppConfig>();
    }
    return Promise.resolve(this.appConfigNull);
  }

  public setAppConfig(config: AppConfig) {
    // This has already been set so bail out.
    if (config === null || config === undefined) {
      return;
    }

    this.appConfig = config;
    console.log(this.appConfig);

    if (this.appConfigSubject) {
      this.appConfigSubject.next(this.appConfig);
    }
  }

  /*
    Call this if you want to know when EnvSpecific is set.
  */
  public subscribe(caller: any, callback: (caller: any, config: AppConfig) => void) {
    this.appConfigSubject
      .subscribe((_config) => {
        if (_config === null) {
          return;
        }
        callback(caller, _config);
      });
  }

}
