export interface Page<T>{
  totalItems: number;
  numOfPages: number;
  pageSize: number;
  pageContent: T[];
}
