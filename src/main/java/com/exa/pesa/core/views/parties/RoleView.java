package com.exa.pesa.core.views.parties;

import com.exa.pesa.core.model.parties.Role;

/**
 * Created by Andres on 9/10/2017.
 */
public class RoleView {
    private String id;
    private String name;

    public RoleView() {
        super();
    }

    public RoleView(Role model) {
        this(model.getId(), model.getName());
    }

    public RoleView(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
