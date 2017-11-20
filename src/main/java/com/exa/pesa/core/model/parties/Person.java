package com.exa.pesa.core.model.parties;

/**
 * Created by Andres on 22/10/2017.
 */
public class Person {

    private String id;
    private String type;
    private String name;
    private String tinNumber;

    public Person() {
        super();
    }

    public Person(String id, String type, String name, String tinNumber) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.tinNumber = tinNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (type != null ? !type.equals(person.type) : person.type != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return tinNumber != null ? tinNumber.equals(person.tinNumber) : person.tinNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tinNumber != null ? tinNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", tinNumber='" + tinNumber + '\'' +
                '}';
    }
}
