import {Component, OnInit} from "@angular/core";
import {ViewportStateService} from "../../core/exa-services/exa-viewport/viewport-state.service";
import {ViewportBreakpoint} from "../../model/core/viewport-breakpoint.enum";
import {DashboardService} from "../dashboard.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'exp-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  isDesktopViewport: boolean = true;
  allowedAccess: Observable<boolean>;

  constructor(private vp: ViewportStateService, private dashboardService: DashboardService) {
  }

  closeSession(): void{
    this.dashboardService.closeSession();
  }

  ngOnInit(): void {
    this.vp.getViewport().subscribe((currentBreakpoint: ViewportBreakpoint) => {
      this.isDesktopViewport = (currentBreakpoint == ViewportBreakpoint.DESKTOP);
    });

    this.allowedAccess = this.dashboardService.ping();
  }

}
