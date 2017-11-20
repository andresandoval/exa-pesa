import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'exp-spinner',
  template: `
    <div fxFlexFill fxLayoutAlign="center center" class="spinner-container">
      <mat-spinner></mat-spinner>
    </div>
  `,
  styleUrls: ['./spinner.component.scss']
})
export class SpinnerComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
