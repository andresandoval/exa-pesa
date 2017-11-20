package com.exa.pesa.core.services.business;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Parameter;

import java.util.List;

/**
 * Created by Andres on 22/10/2017.
 */
public interface ParameterService {

    List<Parameter> getParameterByGroup(String group) throws BusinessException;
    Parameter getParameterById(String id, String group) throws BusinessException;
}
