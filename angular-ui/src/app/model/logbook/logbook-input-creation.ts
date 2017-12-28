export interface LogbookInputCreation {
  inputDate: String;
  name: string;
  inputReasonId: number;
  materialTypeId: number;
  vehicleTypeId: number;
  vehiclePlate?: string;
  vehicleColorId?: number;
  contactPersonId?: string;
  areaId: number;
  observation?: string;
}
