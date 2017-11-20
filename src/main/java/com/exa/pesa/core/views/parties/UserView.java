package com.exa.pesa.core.views.parties;

import com.exa.pesa.core.model.parties.Role;
import com.exa.pesa.core.model.parties.User;

/**
 * Created by Andres on 9/10/2017.
 */
public class UserView {
    private Integer id;
    private String name;
    private String login;
    private RoleView role;
    private boolean inactive;

    public UserView() {
        super();
    }

    public UserView(User model) {
        this(model.getId(), model.getName(), model.getLogin(), new RoleView(model.getRole()), model.isInactive());
    }

    public UserView(Integer id, String name, String login, RoleView role, boolean inactive) {
        this.id = id;
        this.name = name;
        this.login = login;
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

    public RoleView getRole() {
        return role;
    }

    public void setRole(RoleView role) {
        this.role = role;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }
}
