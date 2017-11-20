import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";
import {ViewportBreakpoint} from "../../../model/core/viewport-breakpoint.enum";

@Injectable()
export class ViewportStateService {

  private currentViewportSubject = new BehaviorSubject<ViewportBreakpoint>(ViewportBreakpoint.DESKTOP);

  constructor() {
  }

  public updateViewport(currentViewport: ViewportBreakpoint): void {
    this.currentViewportSubject.next(currentViewport);
  }

  public getViewport(): Observable<ViewportBreakpoint> {
    return this.currentViewportSubject.asObservable();
  }


}
