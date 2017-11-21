package com.exa.pesa.core.util;

/**
 * Created by Andres on 9/10/2017.
 */
public interface RestEndpoints {


    public static final String PRIVATE_PING = "/api/core/ping";


    public static final String PARTIES_USER_LOGIN = "/api/parties/user/login";
    public static final String PARTIES_PERSON_NAME_FILTER = "/api/parties/person/filter";

    public static final String CHECK_IN_INPUT_LIST = "/api/checkpoint/check-in/input";
    public static final String CHECK_IN_OUTPUT_LIST = "/api/checkpoint/check-in/output";
    public static final String CHECK_IN_SAVE = "/api/checkpoint/check-in/input";
    public static final String CHECK_IN_NEW = "/api/checkpoint/check-in/input/new";
    public static final String CHECK_IN_SINGLE = "/api/checkpoint/check-in/input/{id}";
    public static final String CHECK_IN_UPDATE = "/api/checkpoint/check-in/input/{id}";
    public static final String CHECK_IN_OUT = "/api/checkpoint/check-in/input/{id}/out";

    public static final String LOGBOOK_LIST = "/api/checkpoint/logbook";
    public static final String LOGBOOK_SAVE = "/api/checkpoint/logbook";
    public static final String LOGBOOK_SINGLE = "/api/checkpoint/logbook/{id}";
    public static final String LOGBOOK_OUT = "/api/checkpoint/logbook/{id}/out";

    public static final String PARAMETERS_INPUT_TYPES = "/api/parameters/input-types";
    public static final String PARAMETERS_OUTPUT_TYPES = "/api/parameters/output-types";
    public static final String PARAMETERS_VEHICLE_TYPES = "/api/parameters/vehicle-types";
    public static final String PARAMETERS_COLORS = "/api/parameters/colors";
    public static final String PARAMETERS_AREAS = "/api/parameters/areas";
    public static final String PARAMETERS_MATERIAL_TYPES = "/api/parameters/material-types";

    public static final String VEHICLES_PLATE_FILTER = "/api/vehicles/filter";

    public static final String ENTRY_TYPE_LIST = "/api/entry-types";
}
