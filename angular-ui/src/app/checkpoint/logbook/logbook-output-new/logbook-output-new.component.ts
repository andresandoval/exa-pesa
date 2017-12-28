import {Component, OnInit} from '@angular/core';
import {CheckpointService} from "../../checkpoint.service";
import {HOURS, MINUTES} from "../../../core/exa-utils/exa-constants";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {Person} from "../../../model/parties/person";
import {Parameter} from "../../../model/business/parameter";
import {ViewportStateService} from "../../../core/exa-services/exa-viewport/viewport-state.service";
import {ViewportBreakpoint} from "../../../model/core/viewport-breakpoint.enum";
import {Vehicle} from "../../../model/business/vehicle";
import {ValidateOptionalAutoCompleteOption} from "../../../core/exa-utils/exa-validators";
import {dateToString} from "../../../core/exa-utils/exa-converters";
import {ActivatedRoute, Router} from "@angular/router";
import {LogbookOutputCreation} from "../../../model/logbook/logbook-output-creation";

@Component({
  selector: 'exp-logbook-output-new',
  templateUrl: './logbook-output-new.component.html',
  styleUrls: ['./logbook-output-new.component.scss']
})
export class LogbookOutputNewComponent implements OnInit {

  constructor(private checkPointService: CheckpointService, private vpService: ViewportStateService,
              private formBuilder: FormBuilder, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  //form
  form: FormGroup;

  //lists
  hours: number[] = HOURS;
  minutes: number[] = MINUTES;
  outputReasonTypeList: Observable<Parameter[]>;
  vehicleTypeList: Observable<Parameter[]>;
  vehicleColorList: Observable<Parameter[]>;
  areaList: Observable<Parameter[]>;
  personList: Observable<Person[]>;
  vehicleList: Observable<Vehicle[]>;
  contactPersonList: Observable<Person[]>;

  //layout
  isDesktopBreakpoint: boolean;

  nameDisplay(person: Person): string {
    return person ? person.name : "";
  }

  vehicleDisplay(transport: Vehicle): string {
    return transport ? transport.plate : "";
  }

  createForm(): void {
    const today = new Date();

    this.form = this.formBuilder.group({
      outputDate: [today, [Validators.required]],
      outputHour: [today.getHours(), [Validators.required]],
      outputMinute: [today.getMinutes(), [Validators.required]],
      name: [null, [Validators.required, Validators.maxLength(100), Validators.minLength(5)]],
      outputReason: [null, [Validators.required]],
      vehicleType: ["0", [Validators.required]],
      vehiclePlate: [null],
      vehicleColor: [null],
      contactPerson: [null, [ValidateOptionalAutoCompleteOption]],
      area: [null, [Validators.required]],
      observation: [null, [Validators.maxLength(500)]]
    });

    this.form.controls.vehicleType.valueChanges.subscribe((value) => {
      const plateValidator = (value == "0") ? null : [Validators.required, Validators.maxLength(30)];
      const colorValidator = (value == "0") ? null : [Validators.required];
      this.form.controls.vehiclePlate.setValidators(plateValidator);
      this.form.controls.vehicleColor.setValidators(colorValidator);
      this.form.controls.vehiclePlate.updateValueAndValidity();
      this.form.controls.vehicleColor.updateValueAndValidity();
    });
  }

  loadLists(): void {
    this.outputReasonTypeList = this.checkPointService.getOutputTypes();
    this.vehicleTypeList = this.checkPointService.getVehicleTypes();
    this.vehicleColorList = this.checkPointService.getColors();
    this.areaList = this.checkPointService.getAreas();

    this.form.controls.name.valueChanges.subscribe((value) => {
      let size = ((null == value) ? 0 : value.length);
      if (size < 3)
        this.personList = null;
      else
        this.personList = this.checkPointService.getPersonByFilter(value);
    });

    this.form.controls.vehiclePlate.valueChanges.subscribe((value) => {
      let size = ((null == value) ? 0 : value.length);
      if (size < 1)
        this.vehicleList = null;
      else
        this.vehicleList = this.checkPointService.getVehicleByFilter(value);
    });

    this.form.controls.contactPerson.valueChanges.subscribe((value) => {
      let size = ((null == value) ? 0 : value.length);
      if (size < 1)
        this.contactPersonList = null;
      else
        this.contactPersonList = this.checkPointService.getPersonByFilter(value);
    });
  }

  prepareLayout(): void {
    this.vpService.getViewport().subscribe((viewport: ViewportBreakpoint) => {
      this.isDesktopBreakpoint = (viewport == ViewportBreakpoint.DESKTOP);
    });
  }

  processForm(): LogbookOutputCreation {
    const formValue = this.form.value;
    let formOutputDate: Date = formValue.outputDate;
    let outputDate: Date = new Date(formOutputDate.getFullYear(), formOutputDate.getMonth(), formOutputDate.getDate(),
      formValue.outputHour, formValue.outputMinute, 0, 0);
    let name: string = (typeof formValue.name != "string") ? formValue.name.name : formValue.name;

    const logbook: LogbookOutputCreation = {
      outputDate: dateToString(outputDate),
      name: name.toUpperCase(),
      outputReasonId: formValue.outputReason,
      vehicleTypeId: formValue.vehicleType,
      areaId: formValue.area,
      observation: formValue.observation
    };
    if (logbook.vehicleTypeId != 0) {
      logbook.vehiclePlate =
        (typeof formValue.vehiclePlate != "string") ? formValue.vehiclePlate.plate : formValue.vehiclePlate;
      logbook.vehicleColorId = formValue.vehicleColor;
    }

    if (formValue.contactPerson != null)
      logbook.contactPersonId = formValue.contactPerson.id;

    return logbook;
  }

  submitForm() {
    if (this.form.invalid)
      return;
    const logbook: LogbookOutputCreation = this.processForm();
    this.checkPointService.saveOutputLogbook(logbook).subscribe(() => {
      this.router.navigate(["../"], {relativeTo: this.activatedRoute});
    });
  }

  ngOnInit() {
    this.createForm();
    this.loadLists();
    this.prepareLayout();
  }

}
