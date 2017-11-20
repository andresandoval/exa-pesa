package com.exa.pesa.core.views.business;

import com.exa.pesa.core.model.business.Parameter;

/**
 * Created by Andres on 22/10/2017.
 */
public class ParameterView {
    private String id;
    private String value;

    public ParameterView() {
        super();
    }

    public ParameterView(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public ParameterView(Parameter parameter) {
        this(parameter.getId(), parameter.getValue());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
