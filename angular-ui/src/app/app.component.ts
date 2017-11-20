import {Component, OnDestroy, OnInit} from "@angular/core";
import {MatIconRegistry} from "@angular/material";
import {MediaChange, ObservableMedia} from "@angular/flex-layout";
import {Subscription} from "rxjs/Subscription";
import {ViewportStateService} from "./core/exa-services/exa-viewport/viewport-state.service";
import {ViewportBreakpoint} from "./model/core/viewport-breakpoint.enum";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  viewProviders: [MatIconRegistry]
})
export class AppComponent implements OnInit, OnDestroy {

  private viewportWatcher: Subscription;

  private desktopBreakpoint: string = "gt-sm";

  constructor(private iconReg: MatIconRegistry, private mediaObserver: ObservableMedia, private viewportStateService: ViewportStateService) {

  }

  ngOnInit(): void {
    this.iconReg.registerFontClassAlias('font-awesome', 'fa');
    this.iconReg.setDefaultFontSetClass('fa');

    this.viewportWatcher = this.mediaObserver.subscribe((change: MediaChange) => {
      let currentViewport = this.mediaObserver.isActive(this.desktopBreakpoint) ? ViewportBreakpoint.DESKTOP : ViewportBreakpoint.MOBILE;
      this.viewportStateService.updateViewport(currentViewport);
    });
  }

  ngOnDestroy(): void {
    this.viewportWatcher.unsubscribe();
  }
}
