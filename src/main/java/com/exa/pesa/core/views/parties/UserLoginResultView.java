package com.exa.pesa.core.views.parties;

/**
 * Created by Andres on 9/10/2017.
 */
public class UserLoginResultView {

    private String token;
    private String message;

    public UserLoginResultView() {
        super();
    }

    public UserLoginResultView(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
