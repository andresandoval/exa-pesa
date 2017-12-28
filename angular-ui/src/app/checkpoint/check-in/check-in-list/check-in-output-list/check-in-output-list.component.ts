import {Component, OnInit} from '@angular/core';
import {CheckpointService} from "../../../checkpoint.service";
import {Observable} from "rxjs/Observable";
import {CheckIn} from "../../../../model/check-in/check-in";

@Component({
  selector: 'exp-check-in-output-list',
  templateUrl: './check-in-output-list.component.html',
  styleUrls: ['./check-in-output-list.component.scss']
})
export class CheckInOutputListComponent implements OnInit {

  constructor(private checkpointService: CheckpointService) { }

  checkInList: Observable<CheckIn[]>;

  loadList(): void {
    this.checkInList = this.checkpointService.getCheckInOutputList();
  }

  registerOutput(id: number) : void {
    this.checkpointService.registerCheckInOut(id).subscribe(() => {
     this.loadList();
    });
  }

  ngOnInit() {
    this.loadList();
  }

}
