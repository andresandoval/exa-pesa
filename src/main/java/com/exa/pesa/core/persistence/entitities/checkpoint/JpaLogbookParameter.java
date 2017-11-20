package com.exa.pesa.core.persistence.entitities.checkpoint;

import com.exa.pesa.core.model.business.Parameter;
import com.exa.pesa.core.persistence.entitities.business.JpaParameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Andres on 22/10/2017.
 */
@Entity
@Table(name = "Bitacora_Parametros")
public class JpaLogbookParameter {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumns({
            @JoinColumn(name = "id_parametro", referencedColumnName = "param_id"),
            @JoinColumn(name = "grupo_parametro", referencedColumnName = "grupo")
    })
    private JpaParameter parameter;

    public JpaLogbookParameter() {
        super();
    }

    public JpaLogbookParameter(JpaParameter parameter) {
        this.parameter = parameter;
    }

    public JpaLogbookParameter(Parameter model){
        this.parameter = new JpaParameter(model);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JpaParameter getParameter() {
        return parameter;
    }

    public void setParameter(JpaParameter parameter) {
        this.parameter = parameter;
    }
}
