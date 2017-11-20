import {Injectable} from "@angular/core";
import {HttpClient, HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import {HttpStatusCodes} from "../../../model/core/http-status-codes";
import {MessageView} from "../../../model/core/message-view";

@Injectable()
export class ExaHttpService {

  private httpOptions: any = {observe: 'response'};

  constructor(private httpClient: HttpClient) {
  }

  public get<T>(url: string): Observable<T> {
    return this.httpClient.get<T>(url, this.httpOptions)
      .map((response: HttpResponse<T>) => {
        if (!response.ok)
          throw new Error(response.statusText);
        return response.body;
      });
  }

  public login<T>(url: string, data: any): Observable<T> {
    return this.httpClient.post<T>(url, data, this.httpOptions)
      .map((response: HttpResponse<T>) => {
        if (!response.ok) {
          if (response.body["message"])
            throw new Error(response.body["message"] as string);
          else
            throw new Error(response.statusText);
        }
        return response.body;
      });
  }

  public ping<T>(url: string, data?: any): Observable<T> {
    return this.httpClient.post<T>(url, data, this.httpOptions)
      .map((response: HttpResponse<T>) => {
        if (!response.ok)
          throw new Error(response.statusText);
        return response.body;
      });
  }


  public post<T>(url: string, data: any): Observable<T> {
    return this.httpClient.post<T>(url, data, this.httpOptions)
      .map((response: HttpResponse<T>) => {
        if (response.status != HttpStatusCodes.CREATED) {
          if (response.body["message"])
            throw new Error(response.body["message"] as string);
          else
            throw new Error(response.statusText);
        }
        return response.body;
      });
  }

  public patch<T>(url: string, data?: any): Observable<T> {
    return this.httpClient.patch<T>(url, data, this.httpOptions)
      .map((response: HttpResponse<T>) => {
        if (!response.ok) {
          if (response.body["message"])
            throw new Error(response.body["message"] as string);
          else
            throw new Error(response.statusText);
        }
        return response.body;
      });
  }

  public put<T>(url: string, data?: any): Observable<T> {
    return this.httpClient.put<T>(url, data, this.httpOptions)
      .map((response: HttpResponse<T>) => {
        if (!response.ok) {
          if (response.body["message"])
            throw new Error(response.body["message"] as string);
          else
            throw new Error(response.statusText);
        }
        return response.body;
      });
  }

}
