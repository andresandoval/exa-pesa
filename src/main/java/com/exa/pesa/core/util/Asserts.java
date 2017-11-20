package com.exa.pesa.core.util;

import com.exa.pesa.core.Main;
import com.exa.pesa.core.exceptions.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created by Andres on 9/10/2017.
 */
public class Asserts {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    // NOT NULL
    public static Boolean nonNull(Object object, String message) throws BusinessException {
        if (Objects.isNull(object)) {
            BusinessException ex = new BusinessException(message);
            logger.info(message, ex);
            throw ex;
        }
        return Boolean.TRUE;
    }

    public static Boolean nonNull(Object object) throws BusinessException {
        return nonNull(object, ResourceBundleConstants.MESSAGES_EXCEPTION_EXPECTED_NOT_NULL);
    }

    public static Boolean nonNullParams(Object... objects) throws BusinessException {
        nonNull(objects, ResourceBundleConstants.MESSAGES_EXCEPTION_EXPECTED_NOT_NULL_PARAMETERS);
        if (objects.length == 1)
            return nonNull(objects[0], ResourceBundleConstants.MESSAGES_EXCEPTION_EXPECTED_NOT_NULL_PARAMETERS);
        for (int i = 0; i < objects.length; i++) {
            nonNull(objects[i], String.format("%s (%d/%d)", ResourceBundleConstants.MESSAGES_EXCEPTION_EXPECTED_NOT_NULL_PARAMETERS, i + 1, objects.length));
        }
        return Boolean.TRUE;
    }

    // TRUE

    public static Boolean isTrue(Boolean expresion, String message) throws BusinessException {
        if (Boolean.FALSE.equals(expresion)) {
            BusinessException ex = new BusinessException(message);
            logger.info(message, ex);
            throw ex;
        }
        return Boolean.TRUE;
    }

    public static Boolean isTrue(Boolean expresion) throws BusinessException {
        return isTrue(expresion, ResourceBundleConstants.MESSAGES_EXCEPTION_EXPECTED_TRUE);
    }

    // FALSE

    public static Boolean isFalse(Boolean expresion, String message) throws BusinessException {
        if (Boolean.TRUE.equals(expresion)){
            BusinessException ex = new BusinessException(message);
            logger.info(message, ex);
            throw ex;
        }
        return Boolean.TRUE;
    }

    public static Boolean isFalse(Boolean expresion) throws BusinessException {
        return isFalse(expresion, ResourceBundleConstants.MESSAGES_EXCEPTION_EXPECTED_FALSE);
    }
}
