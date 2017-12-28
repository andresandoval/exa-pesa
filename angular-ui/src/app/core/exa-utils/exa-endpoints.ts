import {SERVER_URL} from "../../../environments/environment";
//dashboard
export const URL_PING : string = SERVER_URL + "/core/ping";

//parties
export const URL_PERSON_BY_NAME_FILTER : string = SERVER_URL + "/parties/person/filter?name={name}";
export const URL_LOGIN : string = SERVER_URL + "/parties/user/login";

//parameters
export const URL_PARAMETER_INPUT_TYPES : string = SERVER_URL + "/parameters/input-types";
export const URL_PARAMETER_OUTPUT_TYPES : string = SERVER_URL + "/parameters/output-types";
export const URL_PARAMETER_VEHICLE_TYPES : string = SERVER_URL + "/parameters/vehicle-types";
export const URL_PARAMETER_COLORS : string = SERVER_URL + "/parameters/colors";
export const URL_PARAMETER_AREAS : string = SERVER_URL + "/parameters/areas";
export const URL_PARAMETER_MATERIAL_TYPES : string = SERVER_URL + "/parameters/material-types";


//transports
export const URL_VEHICLE_BY_PLATE_FILTER : string = SERVER_URL + "/vehicles/filter?plate={plate}";

//checkpoint -> logbook
export const URL_LOGBOOK_LIST: string = SERVER_URL + "/checkpoint/logbook?page={page}&size={size}&filter={filter}";
export const URL_LOGBOOK_INPUT_SAVE: string = SERVER_URL + "/checkpoint/logbook/input";
export const URL_LOGBOOK_OUTPUT_SAVE: string = SERVER_URL + "/checkpoint/logbook/output";
export const URL_LOGBOOK_OUTPUT_REGISTER: string = SERVER_URL + "/checkpoint/logbook/output/{id}";
export const URL_LOGBOOK_SINGLE: string = SERVER_URL + "/checkpoint/logbook/{id}";

//checkpoint -> checkin
export const URL_CHECK_IN_INPUT_LIST: string = SERVER_URL + "/checkpoint/check-in/input";
export const URL_CHECK_IN_OUTPUT_LIST: string = SERVER_URL + "/checkpoint/check-in/output";
export const URL_CHECK_IN_SAVE: string = SERVER_URL + "/checkpoint/check-in/input";
export const URL_CHECK_IN_NEW: string = SERVER_URL + "/checkpoint/check-in/input/new";
export const URL_CHECK_IN_SINGLE: string = SERVER_URL + "/checkpoint/check-in/input/{id}";
export const URL_CHECK_IN_UPDATE: string = SERVER_URL + "/checkpoint/check-in/input/{id}";
export const URL_CHECK_IN_OUT: string = SERVER_URL + "/checkpoint/check-in/input/{id}/out";

export const URL_CHECK_IN_ENTRY_TYPES: string = SERVER_URL + "/entry-types";

