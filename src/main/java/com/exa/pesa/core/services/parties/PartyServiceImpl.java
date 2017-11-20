package com.exa.pesa.core.services.parties;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.parties.Person;
import com.exa.pesa.core.model.parties.User;
import com.exa.pesa.core.persistence.daos.parties.JpaPersonDAO;
import com.exa.pesa.core.persistence.daos.parties.JpaUserDAO;
import com.exa.pesa.core.persistence.entitities.parties.JpaPerson;
import com.exa.pesa.core.persistence.entitities.parties.JpaUser;
import com.exa.pesa.core.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Andres on 9/10/2017.
 */
@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    private JpaUserDAO jpaUserDAO;

    @Autowired
    private JpaPersonDAO jpaPersonDAO;

    @Override
    public User getUserByLogin(String login) throws BusinessException {
        if (Objects.isNull(login))
            throw new BusinessException("Error de estrada");
        JpaUser result = jpaUserDAO.findByLogin(login);
        if (Objects.isNull(result))
            return null;
        return result.getModel();
    }

    @Override
    public List<Person> getPersonByNameFilter(String name) throws BusinessException {
        Asserts.nonNullParams(name);
        Set<JpaPerson> jpaResult = jpaPersonDAO.findTop20ByNameContainingIgnoreCaseOrderByNameAsc(name);
        if (Objects.isNull(jpaResult) || jpaResult.size() <= 0)
            return null;
        final List<Person> modelResult = new ArrayList<>();
        jpaResult.stream().forEach(jpaR -> modelResult.add(jpaR.getModel()));
        return modelResult;
    }

    @Override
    public Person getPersonById(String id) throws BusinessException {
        Asserts.nonNullParams(id);
        JpaPerson jpaPerson = this.jpaPersonDAO.findOne(id);
        if(Objects.isNull(jpaPerson))
            return  null;
        return jpaPerson.getModel();
    }
}
