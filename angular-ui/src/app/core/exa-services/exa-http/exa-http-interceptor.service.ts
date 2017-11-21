import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {ExaTokenService} from "../exa-security/exa-token.service";

@Injectable()
export class ExaHttpInterceptorService implements HttpInterceptor {

  constructor(private tokenService: ExaTokenService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.tokenService.getAuthToken();
    if (null !== token) {
      const changedReq = req.clone({headers: req.headers.set(ExaTokenService.APP_TOKEN_HEADER_NAME, token)});
      return next.handle(changedReq);
    }
    return next.handle(req);
  }

}
