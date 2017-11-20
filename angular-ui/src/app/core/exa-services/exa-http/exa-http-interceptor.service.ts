import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {ExaTokenService} from "../exa-security/exa-token.service";
import {AppConfigService} from "../exa-config/app-config.service";
import {SERVER_URL} from "../../../../environments/environment";

@Injectable()
export class ExaHttpInterceptorService implements HttpInterceptor {

  constructor(private tokenService: ExaTokenService, private appConfig: AppConfigService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const newUrlReq = req.clone({url: req.url.replace(SERVER_URL, this.appConfig.appConfig.apiRestUrl)});

    let token = this.tokenService.getAuthToken();
    if (null !== token) {
      const changedReq = newUrlReq.clone({headers: req.headers.set(ExaTokenService.APP_TOKEN_HEADER_NAME, token)});
      return next.handle(changedReq);
    }
    return next.handle(newUrlReq);
  }

}
