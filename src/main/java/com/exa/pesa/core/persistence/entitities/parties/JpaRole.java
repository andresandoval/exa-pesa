package com.exa.pesa.core.persistence.entitities.parties;

import com.exa.pesa.core.model.parties.Role;
import com.exa.pesa.core.model.parties.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andres on 9/10/2017.
 */
@Entity
@Table(name = "seg_roles")
public class JpaRole {
    @Id
    @Column(name = "rol_id", length = 20, nullable = false)
    private String id;

    @Column(name = "nombre", length = 100, nullable = true)
    private String name;

    public Role getModel(){
        Role model = new Role();
        model.setId(this.id);
        model.setName(this.name);
        return model;
    }
}
