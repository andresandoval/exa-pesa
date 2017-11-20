import {Injectable} from '@angular/core';
import {MatDialog} from "@angular/material";
import {Observable} from "rxjs/Observable";
import {ConfirmationResult} from "../../../model/core/dialog-result";
import {ConfirmationDialogComponent} from "../../exa-components/confirmation-dialog/confirmation-dialog.component";

@Injectable()
export class ExaDialogService {

  constructor(private matDialog: MatDialog) {
  }

  confirm(message?: string): Observable<ConfirmationResult> {
    return Observable.create(observer => {
      const dialogRef = this.matDialog.open(ConfirmationDialogComponent, {
        data: {message: message}
      });
      dialogRef.afterClosed().subscribe((result: ConfirmationResult) => {
        if (result == ConfirmationResult.YES)
          observer.next(ConfirmationResult.YES);
        else if (result == ConfirmationResult.NO)
          observer.next(ConfirmationResult.NO);
        else
          observer.next(ConfirmationResult.NO);
        observer.complete();
      });
    });
  }

}
