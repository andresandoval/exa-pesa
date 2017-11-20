package com.exa.pesa.core.persistence.entitities.business;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Andres on 22/10/2017.
 */

@Embeddable
public class JpaParametersPK implements Serializable{
    @Column(name = "param_id", nullable = false)
    private String id;

    @Column(name = "grupo", nullable = false)
    private String group;

    public JpaParametersPK() {
        super();
    }

    public JpaParametersPK(String id, String group) {
        this.id = id;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
