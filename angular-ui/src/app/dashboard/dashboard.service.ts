import {Injectable} from '@angular/core';
import {ExaHttpService} from "../core/exa-services/exa-http/exa-http.service";
import {Observable} from "rxjs/Observable";
import {ExaDialogService} from "../core/exa-services/exa-dialog/exa-dialog.service";
import {MatSnackBar, MatSnackBarConfig, MatSnackBarRef, SimpleSnackBar} from "@angular/material";
import {URL_LOGIN, URL_PING} from "../core/exa-utils/exa-endpoints";
import {ExaTokenService} from "../core/exa-services/exa-security/exa-token.service";
import {UserLogin} from "../model/parties/user-login";
import {ExaSpinnerService} from "../core/exa-services/exa-dialog/exa-spinner.service";

@Injectable()
export class DashboardService {

  constructor(private httpService: ExaHttpService, private dialogService: ExaDialogService,
              private snackBar: MatSnackBar, private tokenService: ExaTokenService,
              private spinnerService: ExaSpinnerService) {
  }

  private showSnackBar(message: string, duration?: number): MatSnackBarRef<SimpleSnackBar> {
    const defaultSnackDuration: number = 5000;
    const config: MatSnackBarConfig = {duration: duration ? duration : defaultSnackDuration};
    return this.snackBar.open(message, null, config);
  }

  login(data: any): void {
    this.spinnerService.reveal();
    let queryingMsg = this.showSnackBar("Consultando...");
    this.tokenService.deleteAuthToken();

    this.httpService.login<UserLogin>(URL_LOGIN, data).subscribe((loginResult: UserLogin) => {
      this.showSnackBar(loginResult.message);
      this.tokenService.setAuthToken(loginResult.token);
      window.location.reload();
    }, (error: Error) => {
      this.showSnackBar(error["error"].message);
      this.spinnerService.hide();
    }, () => {
      queryingMsg.dismiss();
      this.spinnerService.hide();
    });
  }

  ping(): Observable<boolean> {
    return Observable.create(observer => {
      if (!this.tokenService.existsAuthToken()) {
        observer.next(false);
        observer.complete();
        return;
      }
      this.httpService.get(URL_PING).subscribe(result => {
        observer.next(true);
      }, (error: Error) => {
        observer.next(false);
      }, () => {
        observer.complete();
      });
    });
  }

  closeSession(): void {
    this.tokenService.deleteAuthToken();
    window.location.reload();
  }

}
