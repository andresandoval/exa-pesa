package com.exa.pesa.core.views.parties;

/**
 * Created by Andres on 9/10/2017.
 */
public class UserLoginInputView {
    private String username;
    private String password;

    public UserLoginInputView() {
        super();
    }

    public UserLoginInputView(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
