package com.exa.pesa.core.persistence.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        if(Objects.isNull(localDateTime))
            return null;
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return  Timestamp.valueOf(zonedDateTime.toLocalDateTime());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return Objects.isNull(dbData) ? null : dbData.toLocalDateTime();
    }
}
