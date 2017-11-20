import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'leadingZeros'
})
export class LeadingZerosPipe implements PipeTransform {

  transform(value: any, number: number): any {
    let strValue: string = `${value}`;
    if (strValue.length >= number)
      return value;
    for (let i = strValue.length; i < number; i++) {
      strValue = `0${strValue}`;
    }
    return strValue;
  }

}
