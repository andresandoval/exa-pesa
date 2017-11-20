package com.exa.pesa.core.model.parties;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Objects;

/**
 * Created by Andres on 9/10/2017.
 */
public class User {

    private Integer id;
    private String name;
    private String login;
    private String password;
    private String passwordWeb;
    private Role role;
    private boolean inactive;

    public User() {
        super();
    }

    public User(Integer id, String name, String login, String password, String passwordWeb, Role role, boolean
            inactive) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.passwordWeb = passwordWeb;
        this.role = role;
        this.inactive = inactive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordWeb() {
        return passwordWeb;
    }

    public void setPasswordWeb(String passwordWeb) {
        this.passwordWeb = passwordWeb;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public String getBasicAuthToken() throws UnsupportedEncodingException {
        StringBuffer tokenPrefix = new StringBuffer();
        tokenPrefix.append("Basic ");
        StringBuffer tokenValue = new StringBuffer();
        tokenValue.append(this.login);
        tokenValue.append(":");
        if (Objects.nonNull(this.passwordWeb))
            tokenValue.append(this.passwordWeb);
        String base64Value = Base64.getEncoder().encodeToString(tokenValue.toString().getBytes("UTF-8"));
        tokenPrefix.append(base64Value);
        return tokenPrefix.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (inactive != user.inactive) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (passwordWeb != null ? !passwordWeb.equals(user.passwordWeb) : user.passwordWeb != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordWeb != null ? passwordWeb.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (inactive ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", passwordWeb='" + passwordWeb + '\'' +
                ", role=" + role +
                ", inactive=" + inactive +
                '}';
    }
}
