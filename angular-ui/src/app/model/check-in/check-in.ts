import {EntryType} from "./entry-type";
import {Vehicle} from "../business/vehicle";

export interface CheckIn {
  id: number;
  siteId: number;
  entryType: EntryType;
  inputDate: Date;
  outputDate: Date;
  transport: Vehicle;
  notRegistered: boolean;
  tiketNumber: string;
  lotCode: string;
  state: number;
  photoPath: string;
  automatic: boolean;
  observation: string;
  meetsConditions: boolean;
  qualified: boolean;
}
