package com.exa.pesa.core.persistence.entitities.checkpoint;

import com.exa.pesa.core.model.checkpoint.EntryType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andres on 21/10/2017.
 */
@Entity
@Table(name = "tipoentrada")
public class JpaEntryType {

    @Id
    @Column(name = "tipo_entrada", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String name;

    public JpaEntryType() {
        super();
    }

    public JpaEntryType(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public EntryType getModel() {
        return new EntryType(id, name);
    }
}
