package com.exa.pesa.core.controllers.handlers;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.views.MessageView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.MessageDigest;

/**
 * Created by Andres on 9/10/2017.
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<MessageView> onBusinessException(BusinessException businessException) {
        final MessageView messageView = new MessageView(businessException.getMessage());
        return new ResponseEntity<>(messageView, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    private ResponseEntity<MessageView> onUserNotFoundException(UsernameNotFoundException e){
        final MessageView messageView = new MessageView("El usuario con el que inició session no existe");
        return new ResponseEntity<>(messageView, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    private ResponseEntity<MessageView> onOtherException(Throwable e){
        final MessageView messageView = new MessageView("Ocurrió un error inesperado, por favor, intentelo nuevamente");
        e.printStackTrace();
        return new ResponseEntity<>(messageView, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
