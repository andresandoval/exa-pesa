package com.exa.pesa.core.controllers.parties;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.parties.User;
import com.exa.pesa.core.services.parties.PartyService;
import com.exa.pesa.core.util.Asserts;
import com.exa.pesa.core.util.ResourceBundleConstants;
import com.exa.pesa.core.util.ResourceBundleFactory;
import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.views.parties.UserLoginInputView;
import com.exa.pesa.core.views.parties.UserLoginResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Andres on 9/10/2017.
 */
@RestController()
public class UserController {

    private final ResourceBundleFactory resourceBundleFactory = new ResourceBundleFactory();

    @Autowired
    private PartyService partyService;


    @RequestMapping(value = RestEndpoints.PARTIES_USER_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<UserLoginResultView> loginUser(@RequestBody UserLoginInputView loginData) throws
            BusinessException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Asserts.nonNull(loginData, "¡Error de entrada, no hay datos para el inicio de sesión!");
        Asserts.nonNull(loginData.getUsername(), "¡Error de entrada, falta el nombre de usuario!");
        Asserts.nonNull(loginData.getPassword(), "¡Error de entrada, falta la contraseña!");

        User userQuery = partyService.getUserByLogin(loginData.getUsername());
        Asserts.nonNull(userQuery, "El nombre de usuario no existe");
        Asserts.nonNull(userQuery.getPasswordWeb(), "El usuario no esta autorizado para acceder a este sitio");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(loginData.getPassword().getBytes());
        byte[] digest = md.digest();
        String passwordHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        Asserts.isTrue(passwordHash.equals(userQuery.getPasswordWeb().toUpperCase()), "Contraseña incorrecta");

        UserLoginResultView loginResult = new UserLoginResultView(String.format("Bienvenido %s", userQuery.getName()), userQuery.getBasicAuthToken());
        return new ResponseEntity<>(loginResult, HttpStatus.OK);
    }

}
