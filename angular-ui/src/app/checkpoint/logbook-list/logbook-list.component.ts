import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {LogbookCreation} from "../../model/logbook/logbook-creation";
import {CheckpointService} from "../checkpoint.service";
import {PageRequest} from "../../model/core/page-request";
import {Page} from "../../model/core/page";
import {PageEvent} from "@angular/material";
import {Logbook} from "../../model/logbook/logbook";
import {DEFAULT_PAGE_SIZE, PAGE_SIZE_OPTIONS} from "../../core/exa-utils/exa-constants";

@Component({
  selector: 'exp-logbook-list',
  templateUrl: './logbook-list.component.html',
  styleUrls: ['./logbook-list.component.scss']
})
export class LogbookListComponent implements OnInit {

  constructor(private checkpointService: CheckpointService) {
  }

  pageSizeOptions: number[] = PAGE_SIZE_OPTIONS;
  totalElements: number = 0;
  pageSize: number = DEFAULT_PAGE_SIZE;
  pageIndex: number = 0;
  filter: string = "";

  logbookList: Observable<Logbook[]>;

  loadList(): void {
    const pageRequest: PageRequest = {size: this.pageSize, page: this.pageIndex};
    this.logbookList =
      this.checkpointService.getLogbookListByFilter(pageRequest, this.filter).map((page: Page<Logbook>) => {
        this.totalElements = page.totalItems;
        return page.pageContent;
      });
  }

  onPagerChange(event: PageEvent): void {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadList();
  }

  onFilterChange(value: string): void {
    if (value == this.filter)
      return;
    this.filter = value;
    this.loadList();
  }

  registerOutput(id: number): void {
    alert(id);
  }

  ngOnInit() {
    this.loadList();
  }
}
