import {AbstractControl} from "@angular/forms";

export function ValidateRequiredAutoCompleteOption(control: AbstractControl) {
  if (control.value == null || typeof  control.value != "object")
    return {invalidAutoOption: true};
  return null;
}

export function ValidateOptionalAutoCompleteOption(control: AbstractControl) {
  if (control.value == null || control.value.toString().length <= 0)
    return null;
  if(typeof  control.value != "object")
    return {invalidAutoOption: true};
  return null;
}
