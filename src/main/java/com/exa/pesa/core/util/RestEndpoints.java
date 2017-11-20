package com.exa.pesa.core.util;

/**
 * Created by Andres on 9/10/2017.
 */
public interface RestEndpoints {


    public static final String PRIVATE_PING = "/core/ping";


    public static final String PARTIES_USER_LOGIN = "/parties/user/login";
    public static final String PARTIES_PERSON_NAME_FILTER = "/parties/person/filter";

    public static final String CHECK_IN_INPUT_LIST = "/checkpoint/check-in/input";
    public static final String CHECK_IN_OUTPUT_LIST = "/checkpoint/check-in/output";
    public static final String CHECK_IN_SAVE = "/checkpoint/check-in/input";
    public static final String CHECK_IN_NEW = "/checkpoint/check-in/input/new";
    public static final String CHECK_IN_SINGLE = "/checkpoint/check-in/input/{id}";
    public static final String CHECK_IN_UPDATE = "/checkpoint/check-in/input/{id}";
    public static final String CHECK_IN_OUT = "/checkpoint/check-in/input/{id}/out";

    public static final String LOGBOOK_LIST = "/checkpoint/logbook";
    public static final String LOGBOOK_SAVE = "/checkpoint/logbook";
    public static final String LOGBOOK_SINGLE = "/checkpoint/logbook/{id}";
    public static final String LOGBOOK_OUT = "/checkpoint/logbook/{id}/out";

    public static final String PARAMETERS_INPUT_TYPES = "/parameters/input-types";
    public static final String PARAMETERS_OUTPUT_TYPES = "/parameters/output-types";
    public static final String PARAMETERS_VEHICLE_TYPES = "/parameters/vehicle-types";
    public static final String PARAMETERS_COLORS = "/parameters/colors";
    public static final String PARAMETERS_AREAS = "/parameters/areas";
    public static final String PARAMETERS_MATERIAL_TYPES = "/parameters/material-types";

    public static final String VEHICLES_PLATE_FILTER = "/vehicles/filter";

    public static final String ENTRY_TYPE_LIST = "/entry-types";
}
