import {ApplicationRef, ComponentFactoryResolver, Injectable, Injector} from '@angular/core';
import {SpinnerComponent} from "../../exa-components/spinner/spinner.component";
import {ComponentPortal, DomPortalHost} from "@angular/cdk/portal";

@Injectable()
export class ExaSpinnerService {

  private loadingSpinnerPortal: ComponentPortal<SpinnerComponent>;
  private bodyPortalHost: DomPortalHost;

  constructor(private componentFactoryResolver: ComponentFactoryResolver, private appRef: ApplicationRef,
              private injector: Injector) {
    this.loadingSpinnerPortal = new ComponentPortal(SpinnerComponent);

    this.bodyPortalHost = new DomPortalHost(
      document.body,
      this.componentFactoryResolver,
      this.appRef,
      this.injector);
  }

  reveal() {
    this.bodyPortalHost.attach(this.loadingSpinnerPortal);
  }

  hide() {
    this.bodyPortalHost.detach();
  }


}
