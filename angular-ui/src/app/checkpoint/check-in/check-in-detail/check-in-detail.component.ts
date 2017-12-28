import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ValidateOptionalAutoCompleteOption} from "../../../core/exa-utils/exa-validators";
import {Vehicle} from "../../../model/business/vehicle";
import {Observable} from "rxjs/Observable";
import {CheckpointService} from "../../checkpoint.service";
import {EntryType} from "../../../model/check-in/entry-type";
import {CheckInCreation} from "../../../model/check-in/check-in-creation";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CheckIn} from "../../../model/check-in/check-in";
import {CheckInUpdate} from "../../../model/check-in/check-in-update";

@Component({
  selector: 'exp-check-in-detail',
  templateUrl: './check-in-detail.component.html',
  styleUrls: ['./check-in-detail.component.scss']
})
export class CheckInDetailComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private checkPointService: CheckpointService, private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  //lists
  vehicleList: Observable<Vehicle[]>;
  entryTypeList: Observable<EntryType[]>;

  //form
  form: FormGroup;
  id: number = null;
  tiketNumber: string = null;
  lotCode: string = null;

  createForm(): void {
    this.form = this.formBuilder.group({
      vehicle: [null, [ValidateOptionalAutoCompleteOption]],
      meetsConditions: [true],
      entryTypeId: [null, [Validators.required]],
      observation: [null, [Validators.maxLength(500)]]
    });

    this.form.get("meetsConditions").valueChanges.subscribe((value: boolean) => {
      let observationValidator = [Validators.maxLength(500)];
      if (!value)
        observationValidator.push(Validators.required);

      this.form.get("observation").setValidators(observationValidator);
      this.form.get("observation").updateValueAndValidity();
    });
  }

  //layout
  listRouterLink: string = "../";
  title: string = "Nueva entrada";

  vehicleDisplay(vehicle: Vehicle): string {
    return vehicle ? vehicle.plate : "";
  }

  loadLists(): void {
    this.entryTypeList = this.checkPointService.getEntryTypes();

    this.form.controls.vehicle.valueChanges.subscribe((value) => {
      if (typeof value != "string") {
        return;
      }
      let size = ((null == value) ? 0 : value.length);
      if (size < 1)
        this.vehicleList = null;
      else
        this.vehicleList = this.checkPointService.getVehicleByFilter(value);
    });

    this.activatedRoute.paramMap.subscribe((params: ParamMap) => {
      this.id = params.get("id") as any;
      let regGetter: Observable<CheckIn> = !this.id ? this.checkPointService.getNewCheckIn() :
        this.checkPointService.getCheckInById(this.id);
      regGetter.subscribe((register: CheckIn) => {
        this.tiketNumber = register.tiketNumber;
        this.lotCode = register.lotCode;
        this.id = register.id;
        this.form.patchValue({
          vehicle: register.transport,
          meetsConditions: register.meetsConditions,
          entryTypeId: register.entryType ? register.entryType.id : null,
          observation: register.observation
        });
        if (!!this.id) {
          this.title = "Editar entrada";
          this.listRouterLink = "../../";
        }

      });
    });
  }

  processCreationForm(): any {
    const formValue = this.form.value;
    if (!this.id) {
      const checkInCreation: CheckInCreation = {
        entryTypeId: formValue.entryTypeId,
        vehiclePlate: formValue.vehicle.plate,
        ticketNumber: this.tiketNumber,
        lotCode: this.lotCode,
        observation: formValue.observation,
        meetsConditions: formValue.meetsConditions
      };
      return checkInCreation;
    }
    const checkInUpdate: CheckInUpdate = {
      id: this.id,
      entryTypeId: formValue.entryTypeId,
      vehiclePlate: formValue.vehicle.plate,
      ticketNumber: this.tiketNumber,
      lotCode: this.lotCode,
      observation: formValue.observation,
      meetsConditions: formValue.meetsConditions
    };
    return checkInUpdate;
  }

  submitForm() {
    if (this.form.invalid)
      return;
    const checkIn: any = this.processCreationForm();
    let saveTrigger: Observable<any> = !this.id ? this.checkPointService.saveCheckIn(checkIn) :
      this.checkPointService.updateCheckIn(this.id, checkIn);

    saveTrigger.subscribe(() => {
      this.router.navigate([this.listRouterLink], {relativeTo: this.activatedRoute});
    });
  }

  ngOnInit() {
    this.createForm();
    this.loadLists();
  }

}
