package com.exa.pesa.core.services.business;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Parameter;
import com.exa.pesa.core.persistence.daos.business.JpaParameterDAO;
import com.exa.pesa.core.persistence.entitities.business.JpaParameter;
import com.exa.pesa.core.persistence.entitities.business.JpaParametersPK;
import com.exa.pesa.core.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Andres on 22/10/2017.
 */
@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private JpaParameterDAO jpaParameterDAO;

    @Override
    public List<Parameter> getParameterByGroup(String group) throws BusinessException {
        Asserts.nonNullParams(group);
        Set<JpaParameter> jpaParameters = this.jpaParameterDAO.findByIdGroupOrderByValueAsc(group);
        if (Objects.isNull(jpaParameters))
            return null;
        final List<Parameter> parameters = new ArrayList<>();
        jpaParameters.stream().forEach(jpaParameter -> parameters.add(jpaParameter.getModel()));
        return parameters;
    }

    @Override
    public Parameter getParameterById(String id, String group) throws BusinessException {
        Asserts.nonNullParams(group, id);
        JpaParameter jpaParameter = this.jpaParameterDAO.findOne(new JpaParametersPK(id, group));
        if(Objects.isNull(jpaParameter))
            return null;
        return jpaParameter.getModel();
    }
}
