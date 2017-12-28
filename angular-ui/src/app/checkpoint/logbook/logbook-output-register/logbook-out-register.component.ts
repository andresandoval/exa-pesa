import {Component, OnInit} from '@angular/core';
import {CheckpointService} from "../../checkpoint.service";
import {HOURS, MINUTES} from "../../../core/exa-utils/exa-constants";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {Parameter} from "../../../model/business/parameter";
import {ViewportStateService} from "../../../core/exa-services/exa-viewport/viewport-state.service";
import {ViewportBreakpoint} from "../../../model/core/viewport-breakpoint.enum";
import {dateToString} from "../../../core/exa-utils/exa-converters";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {LogbookUpdateOut} from "../../../model/logbook/logbook-update-out";
import 'rxjs/add/operator/switchMap';
import {Logbook} from "../../../model/logbook/logbook";

@Component({
  selector: 'exp-logbook-out-register',
  templateUrl: './logbook-out-register.component.html',
  styleUrls: ['./logbook-out-register.component.scss']
})
export class LogbookOutRegisterComponent implements OnInit {

  constructor(private checkPointService: CheckpointService, private vpService: ViewportStateService,
              private formBuilder: FormBuilder, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  //form
  id: number = null;
  form: FormGroup;

  //lists
  hours: number[] = HOURS;
  minutes: number[] = MINUTES;
  outputReasonTypeList: Observable<Parameter[]>;

  //layout
  isDesktopBreakpoint: boolean;
  logbook: Logbook;
  existsLogbook: boolean = false;
  allowedToSave: boolean = false;

  createForm(): void {
    let today = new Date();
    this.form = this.formBuilder.group({
      outputDate: [today, [Validators.required]],
      outputHour: [today.getHours(), [Validators.required]],
      outputMinute: [today.getMinutes(), [Validators.required]],
      outputReason: [null, [Validators.required]],
      observation: [null, [Validators.maxLength(500)]]
    });
  }

  loadLists(): void {
    this.outputReasonTypeList = this.checkPointService.getOutputTypes();
    this.activatedRoute.paramMap.subscribe((params: ParamMap) => {
      this.id = params.get("id") as any;
      this.checkPointService.getLogbookById(this.id).subscribe((logbook: Logbook) => {
        this.logbook = logbook;
        if (null != this.logbook) {
          this.existsLogbook = true;
          if (null == this.logbook.outputDate) {
            this.allowedToSave = true;
          }
        }
      });
    });
  }

  prepareLayout(): void {
    this.vpService.getViewport().subscribe((viewport: ViewportBreakpoint) => {
      this.isDesktopBreakpoint = (viewport == ViewportBreakpoint.DESKTOP);
    });
  }

  processForm(): LogbookUpdateOut {
    const formValue = this.form.value;
    let formOutputDate: Date = formValue.outputDate;
    let outDate: Date = new Date(formOutputDate.getFullYear(), formOutputDate.getMonth(), formOutputDate.getDate(),
      formValue.outputHour, formValue.outputMinute, 0, 0);

    const logbook: LogbookUpdateOut = {
      outputDate: dateToString(outDate),
      outputReasonId: formValue.outputReason,
      observation: formValue.observation
    };
    return logbook;
  }

  submitForm() {
    if (this.form.invalid)
      return;

    const logbook: LogbookUpdateOut = this.processForm();
    console.log(logbook);

    this.checkPointService.registerLogbookOutput(this.id, logbook).subscribe(() => {
      this.router.navigate(["../../"], {relativeTo: this.activatedRoute});
    });
  }

  ngOnInit() {
    this.createForm();
    this.loadLists();
    this.prepareLayout();
  }


}
