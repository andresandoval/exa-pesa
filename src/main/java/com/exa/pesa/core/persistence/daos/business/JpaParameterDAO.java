package com.exa.pesa.core.persistence.daos.business;

import com.exa.pesa.core.persistence.entitities.business.JpaParameter;
import com.exa.pesa.core.persistence.entitities.business.JpaParametersPK;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by Andres on 22/10/2017.
 */
public interface JpaParameterDAO extends CrudRepository<JpaParameter, JpaParametersPK>{

    Set<JpaParameter> findByIdGroupOrderByValueAsc(String group);

}
