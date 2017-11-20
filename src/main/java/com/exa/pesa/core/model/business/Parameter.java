package com.exa.pesa.core.model.business;

import com.exa.pesa.core.persistence.entitities.business.JpaParametersPK;

import javax.persistence.EmbeddedId;

/**
 * Created by Andres on 22/10/2017.
 */
public class Parameter {
    private String id;
    private String group;
    private String description;
    private String value;

    public Parameter() {
        super();
    }

    public Parameter(String id, String group, String description, String value) {
        this.id = id;
        this.group = group;
        this.description = description;
        this.value = value;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (id != null ? !id.equals(parameter.id) : parameter.id != null) return false;
        if (group != null ? !group.equals(parameter.group) : parameter.group != null) return false;
        if (description != null ? !description.equals(parameter.description) : parameter.description != null)
            return false;
        return value != null ? value.equals(parameter.value) : parameter.value == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", description='" + description + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
