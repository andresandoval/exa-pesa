import {Component, OnInit} from '@angular/core';
import {CheckpointService} from "../../../checkpoint.service";
import {Observable} from "rxjs/Observable";
import {CheckIn} from "../../../../model/check-in/check-in";

@Component({
  selector: 'exp-check-in-input-list',
  templateUrl: './check-in-input-list.component.html',
  styleUrls: ['./check-in-input-list.component.scss']
})
export class CheckInInputListComponent implements OnInit {

  constructor(private checkpointService: CheckpointService) { }

  checkInList: Observable<CheckIn[]>;

  loadList(): void {
    this.checkInList = this.checkpointService.getCheckInInputList();
  }

  ngOnInit() {
    this.loadList();
  }

}
