import {Parameter} from "../business/parameter";
import {Person} from "../parties/person";

export interface Logbook {
  id: number,
  inputDate: Date;
  outputDate?: Date;
  name: string;
  inputReazon: Parameter;
  outputReazon: Parameter;
  materialType: Parameter;
  vehicleType: Parameter;
  vehiclePlate?: string;
  vehicleColor?: Parameter;
  contactPerson?: Person;
  area: Parameter;
  observation?: string;
}
