package com.exa.pesa.core.persistence.entitities.parties;

import com.exa.pesa.core.model.parties.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andres on 22/10/2017.
 */
@Entity
@Table(name = "Persona")
public class JpaPerson {

    @Id
    @Column(name = "persona_id", nullable = false)
    private String id;

    @Column(name = "tipoperson_id", nullable = false)
    private String type;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "ruc", nullable = false)
    private String tinNumber;

    public JpaPerson() {
        super();
    }

    public JpaPerson(String id, String type, String name, String tinNumber) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.tinNumber = tinNumber;
    }

    public JpaPerson(Person model) {
        this.id = model.getId();
        this.type = model.getType();
        this.name = model.getName();
        this.tinNumber = model.getTinNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public Person getModel() {
        return new Person(id, type, name, tinNumber);
    }
}
