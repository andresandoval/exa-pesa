import {Component, Inject, Input, OnInit} from '@angular/core';
import {ConfirmationResult} from "../../../model/core/dialog-result";
import {MAT_DIALOG_DATA} from "@angular/material";

@Component({
  selector: 'exp-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.scss']
})
export class ConfirmationDialogComponent implements OnInit {

  @Input() title: string;
  @Input() message: string;
  @Input() yesLabel: string;
  @Input() noLabel: string;

  yesOption: ConfirmationResult = ConfirmationResult.YES;
  noOption: ConfirmationResult = ConfirmationResult.NO;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {
    if(data["message"])
      this.message = data["message"];
  }

  ngOnInit() {
    if(!this.title)
      this.title = "Confirmación";
    if(!this.message)
      this.message = "¿Confirma la acción seleccionada?";
    if(!this.yesLabel)
      this.yesLabel = "Si";
    if(!this.noLabel)
      this.noLabel = "No";
  }

}
