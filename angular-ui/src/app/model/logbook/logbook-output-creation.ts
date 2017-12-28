export interface LogbookOutputCreation {
  outputDate: String;
  name: string;
  outputReasonId: number;
  vehicleTypeId: number;
  vehiclePlate?: string;
  vehicleColorId?: number;
  contactPersonId?: string;
  areaId: number;
  observation?: string;
}
