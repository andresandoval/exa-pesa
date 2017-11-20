package com.exa.pesa.core.model.checkpoint;

import com.exa.pesa.core.persistence.entitities.checkpoint.JpaEntryType;

/**
 * Created by Andres on 21/10/2017.
 */
public class EntryType {
    private Integer id;
    private String name;

    public EntryType() {
        super();
    }

    public EntryType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public EntryType(JpaEntryType entryType) {
        this(entryType.getId(), entryType.getName());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntryType entryType = (EntryType) o;

        if (id != null ? !id.equals(entryType.id) : entryType.id != null) return false;
        return name != null ? name.equals(entryType.name) : entryType.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EntryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
