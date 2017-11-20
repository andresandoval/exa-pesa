package com.exa.pesa.core.services.parties;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.parties.Person;
import com.exa.pesa.core.model.parties.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Andres on 9/10/2017.
 */
public interface PartyService {

    User getUserByLogin(String login) throws BusinessException;

    List<Person> getPersonByNameFilter(String name) throws BusinessException;

    Person getPersonById(String id) throws BusinessException;

}
