import {Injectable} from "@angular/core";

@Injectable()
export class ExaTokenService {

  private static APP_TOKEN_STORAGE_NAME: string = "EXA_PESA_AUTH_1.0";
  public static APP_TOKEN_HEADER_NAME: string = "Authorization";

  constructor() {
  }

  private isStorageSupported(): boolean {
    return (typeof(Storage) !== "undefined");
  }

  public deleteAuthToken(): void {
    if (!this.isStorageSupported()) return;
    localStorage.removeItem(ExaTokenService.APP_TOKEN_STORAGE_NAME);
    sessionStorage.removeItem(ExaTokenService.APP_TOKEN_STORAGE_NAME);
  }

  public getAuthToken(): string {
    if (!this.isStorageSupported()) return null;
    let token: string = sessionStorage.getItem(ExaTokenService.APP_TOKEN_STORAGE_NAME);
    if (null == token)
      token = localStorage.getItem(ExaTokenService.APP_TOKEN_STORAGE_NAME);
    return token;
  }

  public setAuthToken(tokenValue: string, persist: boolean = false): void {
    if (this.isStorageSupported()) {
      sessionStorage.removeItem(ExaTokenService.APP_TOKEN_STORAGE_NAME);
      localStorage.removeItem(ExaTokenService.APP_TOKEN_STORAGE_NAME);
      if (persist) {
        localStorage.setItem(ExaTokenService.APP_TOKEN_STORAGE_NAME, tokenValue);
      } else {
        sessionStorage.setItem(ExaTokenService.APP_TOKEN_STORAGE_NAME, tokenValue);
      }
    }
  }

  public existsAuthToken(): boolean {
    if (!this.isStorageSupported())
      return false;
    if (null !== sessionStorage.getItem(ExaTokenService.APP_TOKEN_STORAGE_NAME))
      return true;
    if (null !== localStorage.getItem(ExaTokenService.APP_TOKEN_STORAGE_NAME))
      return true;
    return false;
  }
}
