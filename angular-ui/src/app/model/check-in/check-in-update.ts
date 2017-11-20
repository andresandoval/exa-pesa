export interface CheckInUpdate {
  id: number;
  entryTypeId: number;
  ticketNumber: string;
  lotCode: string;
  vehiclePlate: string;
  observation: string;
  meetsConditions: boolean;
}
