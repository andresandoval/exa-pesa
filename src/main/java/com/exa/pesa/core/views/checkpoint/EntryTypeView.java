package com.exa.pesa.core.views.checkpoint;

import com.exa.pesa.core.model.checkpoint.EntryType;
import com.exa.pesa.core.persistence.entitities.checkpoint.JpaEntryType;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Andres on 21/10/2017.
 */
public class EntryTypeView {
    private Integer id;
    private String name;

    public EntryTypeView() {
        super();
    }

    public EntryTypeView(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public EntryTypeView(EntryType entryType) {
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
}
