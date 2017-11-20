package com.exa.pesa.core.persistence.entitities.business;

import com.exa.pesa.core.model.business.Parameter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Andres on 22/10/2017.
 */
@Entity
@Table(name = "Parametros")
public class JpaParameter {

    @EmbeddedId
    private JpaParametersPK id;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "valor", nullable = false)
    private String value;

    public JpaParameter() {
        super();
    }

    public JpaParameter(JpaParametersPK id, String description, String value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public JpaParameter(Parameter model){
        this.id = new JpaParametersPK(model.getId(), model.getGroup());
        this.description = model.getDescription();
        this.value = model.getValue();
    }
    public JpaParametersPK getId() {
        return id;
    }

    public void setId(JpaParametersPK id) {
        this.id = id;
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

    public Parameter getModel() {
        return new Parameter(id.getId(), id.getGroup(), description, value);
    }
}
