package com.exa.pesa.core.views.parties;

import com.exa.pesa.core.model.parties.Person;

/**
 * Created by Andres on 22/10/2017.
 */
public class PersonView {

    private String id;
    private String type;
    private String name;
    private String tinNumber;

    public PersonView() {
        super();
    }

    public PersonView(String id, String type, String name, String tinNumber) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.tinNumber = tinNumber;
    }

    public PersonView(Person person) {
        this(person.getId(), person.getType(), person.getName(), person.getTinNumber());
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
}
