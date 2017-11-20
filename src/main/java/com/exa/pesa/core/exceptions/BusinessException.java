package com.exa.pesa.core.exceptions;

import com.exa.pesa.core.util.ResourceBundleFactory;

/**
 * Created by Andres on 9/10/2017.
 */
public class BusinessException extends RuntimeException{

    private final ResourceBundleFactory resourceBundleFactory = new ResourceBundleFactory();

    public BusinessException() {
    }

    public BusinessException(String message) {
       super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return this.resourceBundleFactory.getText(super.getMessage());
    }
}
