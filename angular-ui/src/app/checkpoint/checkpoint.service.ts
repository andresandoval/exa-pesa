import {Injectable} from "@angular/core";
import {ExaHttpService} from "../core/exa-services/exa-http/exa-http.service";
import {Observable} from "rxjs/Observable";
import {
  URL_CHECK_IN_ENTRY_TYPES,
  URL_CHECK_IN_INPUT_LIST,
  URL_CHECK_IN_NEW,
  URL_CHECK_IN_OUT,
  URL_CHECK_IN_OUTPUT_LIST,
  URL_CHECK_IN_SAVE,
  URL_CHECK_IN_SINGLE,
  URL_CHECK_IN_UPDATE,
  URL_LOGBOOK_LIST,
  URL_LOGBOOK_OUT,
  URL_LOGBOOK_SAVE,
  URL_LOGBOOK_SINGLE,
  URL_PARAMETER_AREAS,
  URL_PARAMETER_COLORS,
  URL_PARAMETER_INPUT_TYPES,
  URL_PARAMETER_MATERIAL_TYPES,
  URL_PARAMETER_OUTPUT_TYPES,
  URL_PARAMETER_VEHICLE_TYPES,
  URL_PERSON_BY_NAME_FILTER,
  URL_VEHICLE_BY_PLATE_FILTER
} from "../core/exa-utils/exa-endpoints";
import {Person} from "../model/parties/person";
import {Parameter} from "../model/business/parameter";
import "rxjs/add/operator/catch";
import {MatSnackBar, MatSnackBarConfig, MatSnackBarRef, SimpleSnackBar} from "@angular/material";
import {Vehicle} from "../model/business/vehicle";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {LogbookCreation} from "../model/logbook/logbook-creation";
import {MessageView} from "../model/core/message-view";
import {ExaDialogService} from "../core/exa-services/exa-dialog/exa-dialog.service";
import {ConfirmationResult} from "../model/core/dialog-result";
import {Page} from "../model/core/page";
import {PageRequest} from "../model/core/page-request";
import {UrlHelper} from "../core/exa-utils/exa-url-helper";
import {Logbook} from "../model/logbook/logbook";
import {LogbookUpdateOut} from "../model/logbook/logbook-update-out";
import {CheckIn} from "../model/check-in/check-in";
import {EntryType} from "../model/check-in/entry-type";
import {CheckInCreation} from "../model/check-in/check-in-creation";
import {CheckInUpdate} from "../model/check-in/check-in-update";
import {ExaSpinnerService} from "../core/exa-services/exa-dialog/exa-spinner.service";


@Injectable()
export class CheckpointService {

  constructor(private httpService: ExaHttpService, private snackBar: MatSnackBar,
              private dialogService: ExaDialogService, private spinnerService: ExaSpinnerService) {
  }

  private showSnackBar(message: string, duration?: number): MatSnackBarRef<SimpleSnackBar> {
    const defaultSnackDuration: number = 5000;
    const config: MatSnackBarConfig = {duration: duration ? duration : defaultSnackDuration};
    return this.snackBar.open(message, null, config);
  }

  getPersonByFilter(name: string): Observable<Person[]> {
    const parameters: Map<string, string> = new Map();
    parameters.set("name", name);
    const url: string = UrlHelper.mapParameters(URL_PERSON_BY_NAME_FILTER, parameters);

    return this.httpService
      .get<Person[]>(url)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pueden cargar las sugerencias");
        return Observable.throw(error);
      });
  }

  getInputTypes(): Observable<Parameter[]> {
    return this.httpService
      .get<Parameter[]>(URL_PARAMETER_INPUT_TYPES)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener la lista de tipos de ingreso");
        return Observable.throw(error);
      });
  }

  getOutputTypes(): Observable<Parameter[]> {
    return this.httpService
      .get<Parameter[]>(URL_PARAMETER_OUTPUT_TYPES)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener la lista de tipos de salida");
        return Observable.throw(error);
      });
  }

  getVehicleTypes(): Observable<Parameter[]> {
    return this.httpService
      .get<Parameter[]>(URL_PARAMETER_VEHICLE_TYPES)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener la lista de tipos de vehiculos");
        return Observable.throw(error);
      });
  }

  getColors(): Observable<Parameter[]> {
    return this.httpService
      .get<Parameter[]>(URL_PARAMETER_COLORS)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener la lista de colores");
        return Observable.throw(error);
      });
  }

  getAreas(): Observable<Parameter[]> {
    return this.httpService
      .get<Parameter[]>(URL_PARAMETER_AREAS)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener la lista de areas");
        return Observable.throw(error);
      });
  }

  getVehicleByFilter(plate: string): Observable<Vehicle[]> {
    const parameters: Map<string, string> = new Map();
    parameters.set("plate", plate);
    const url: string = UrlHelper.mapParameters(URL_VEHICLE_BY_PLATE_FILTER, parameters);

    return this.httpService
      .get<Vehicle[]>(url)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pueden cargar las sugerencias");
        return Observable.throw(error);
      });
  }

  getMaterialTypes(): Observable<Parameter[]> {
    return this.httpService
      .get<Parameter[]>(URL_PARAMETER_MATERIAL_TYPES)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener la lista de tipos de materiales");
        return Observable.throw(error);
      });
  }

  saveLogbook(logbook: LogbookCreation): Observable<any> {
    return Observable.create(observer => {
      this.dialogService.confirm().subscribe((result: ConfirmationResult) => {
        if (result != ConfirmationResult.YES) {
          observer.complete();
          return;
        }
        this.spinnerService.reveal();
        let savingMsg = this.showSnackBar("Guardando...");
        this.httpService.post<MessageView>(URL_LOGBOOK_SAVE, logbook).subscribe((msg) => {
          this.showSnackBar(msg.message);
          observer.next();
        }, (error: Error) => {
          this.showSnackBar(error.message);
          this.spinnerService.hide();
        }, () => {
          savingMsg.dismiss();
          this.spinnerService.hide();
          observer.complete();
        });
      });
    });
  }

  getLogbookListByFilter(pageRequest: PageRequest, filter: string): Observable<Page<Logbook>> {
    const parameters: Map<string, string> = new Map();
    parameters.set("page", pageRequest.page.toString());
    parameters.set("size", pageRequest.size.toString());
    parameters.set("filter", filter);
    const url = UrlHelper.mapParameters(URL_LOGBOOK_LIST, parameters);
    return this.httpService.get<Page<Logbook>>(url).catch((error: ErrorObservable) => {
      this.showSnackBar("No se pudo cargar la lista");
      return Observable.throw(error);
    });
  };

  registerLogbookOut(id: number, logbook: LogbookUpdateOut): Observable<any> {
    return Observable.create(observer => {
      this.dialogService.confirm().subscribe((result: ConfirmationResult) => {
        if (result != ConfirmationResult.YES) {
          observer.complete();
          return;
        }
        this.spinnerService.reveal();

        let savingMsg = this.showSnackBar("Guardando...");
        const parameters: Map<string, string> = new Map();
        parameters.set("id", id.toString());
        const url: string = UrlHelper.mapParameters(URL_LOGBOOK_OUT, parameters);

        this.httpService.patch<MessageView>(url, logbook).subscribe((msg) => {
          this.showSnackBar(msg.message);
          observer.next();
        }, (error: Error) => {
          this.spinnerService.hide();
          this.showSnackBar(error.message);
        }, () => {
          savingMsg.dismiss();
          this.spinnerService.hide();
          observer.complete();
        });
      });
    });
  }

  getLogbookById(id: number): Observable<Logbook> {
    const parameters: Map<string, string> = new Map();
    parameters.set("id", id.toString());
    const url: string = UrlHelper.mapParameters(URL_LOGBOOK_SINGLE, parameters);
    return this.httpService
      .get<Logbook>(url)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener el registro");
        return Observable.throw(error);
      });
  }

  private getCheckInLists(url: string): Observable<CheckIn[]> {
    return this.httpService.get<CheckIn[]>(url).catch((error: ErrorObservable) => {
      this.showSnackBar("No se pudo cargar la lista");
      return Observable.throw(error);
    });
  }

  getCheckInInputList(): Observable<CheckIn[]> {
    return this.getCheckInLists(URL_CHECK_IN_INPUT_LIST);
  }

  getCheckInOutputList(): Observable<CheckIn[]> {
    return this.getCheckInLists(URL_CHECK_IN_OUTPUT_LIST);
  }

  getEntryTypes(): Observable<EntryType[]> {
    return this.httpService.get<CheckIn[]>(URL_CHECK_IN_ENTRY_TYPES).catch((error: ErrorObservable) => {
      this.showSnackBar("No se pudo cargar la lista de tipo de transaccion");
      return Observable.throw(error);
    });
  }

  getNewCheckIn(): Observable<CheckIn> {
    return this.httpService.get<CheckIn[]>(URL_CHECK_IN_NEW).catch((error: ErrorObservable) => {
      this.showSnackBar("No se pudo cargar los codigos de los tickets");
      return Observable.throw(error);
    });
  }

  saveCheckIn(checkIn: CheckInCreation): Observable<any> {
    return Observable.create(observer => {
      this.dialogService.confirm().subscribe((result: ConfirmationResult) => {
        if (result != ConfirmationResult.YES) {
          observer.complete();
          return;
        }
        this.spinnerService.reveal();

        let savingMsg = this.showSnackBar("Guardando...");
        this.httpService.post<MessageView>(URL_CHECK_IN_SAVE, checkIn).subscribe((msg) => {
          this.showSnackBar(msg.message);
          observer.next();
        }, (error: Error) => {
          this.showSnackBar(error.message);
          this.spinnerService.hide();
        }, () => {
          this.spinnerService.hide();
          savingMsg.dismiss();
          observer.complete();
        });
      });
    });
  }

  updateCheckIn(id: number, checkIn: CheckInUpdate): Observable<any> {
    return Observable.create(observer => {
      this.dialogService.confirm().subscribe((result: ConfirmationResult) => {
        if (result != ConfirmationResult.YES) {
          observer.complete();
          return;
        }
        this.spinnerService.reveal();

        let savingMsg = this.showSnackBar("Guardando...");
        const parameters: Map<string, string> = new Map();
        parameters.set("id", id.toString());
        const url: string = UrlHelper.mapParameters(URL_CHECK_IN_UPDATE, parameters);

        this.httpService.patch<MessageView>(url, checkIn).subscribe((msg) => {
          this.showSnackBar(msg.message);
          observer.next();
        }, (error: Error) => {
          this.showSnackBar(error.message);
          this.spinnerService.hide();
        }, () => {
          this.spinnerService.hide();
          savingMsg.dismiss();
          observer.complete();
        });
      });
    });
  }

  getCheckInById(id: number): Observable<CheckIn> {
    const parameters: Map<string, string> = new Map();
    parameters.set("id", id.toString());
    const url: string = UrlHelper.mapParameters(URL_CHECK_IN_SINGLE, parameters);
    return this.httpService
      .get<CheckIn>(url)
      .catch((error: ErrorObservable) => {
        this.showSnackBar("No se pudo obtener el registro");
        return Observable.throw(error);
      });
  }

  registerCheckInOut(id: number): Observable<any> {
    return Observable.create(observer => {
      this.dialogService.confirm("¿Realmente desea dar salida el vehiculo seleccionado?")
        .subscribe((result: ConfirmationResult) => {
          if (result != ConfirmationResult.YES) {
            observer.complete();
            return;
          }
          this.spinnerService.reveal();

          let savingMsg = this.showSnackBar("Registrando salida...");
          const parameters: Map<string, string> = new Map();
          parameters.set("id", id.toString());
          const url: string = UrlHelper.mapParameters(URL_CHECK_IN_OUT, parameters);

          this.httpService.put<MessageView>(url).subscribe((msg) => {
            this.showSnackBar(msg.message);
            observer.next();
          }, (error: Error) => {
            this.spinnerService.hide();
            this.showSnackBar(error.message);
          }, () => {
            savingMsg.dismiss();
            this.spinnerService.hide();
            observer.complete();
          });
        });
    });
  }

}
