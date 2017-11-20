package com.exa.pesa.core.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeUtils {
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public final static LocalDate NEVERENDING = LocalDate.of(9999, Month.DECEMBER, 31);


    public static LocalDate stringToLocalDate(String localDate){
        return LocalDate.parse(localDate, DATE_FORMATTER);
    }

    public static String localDateToString(LocalDate localDate){
        return localDate.format(DATE_FORMATTER);
    }

    public static LocalDateTime isoStringToLocalDateTime(String localDate){
        if(Objects.isNull(localDate))
            return null;
        return LocalDateTime.parse(localDate, DATE_TIME_FORMATTER);
    }

    public static String localDateTimeToIsoString(LocalDateTime localDateTime){
        if(Objects.isNull(localDateTime))
            return null;
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static boolean LocalDateBetween(LocalDate startDate, LocalDate endDate, LocalDate date){
        return startDate.equals(date) || endDate.equals(date) ||
                (startDate.isBefore(date) && endDate.isAfter(date));
    }
}