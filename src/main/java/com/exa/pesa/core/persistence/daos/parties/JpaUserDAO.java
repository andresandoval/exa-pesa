package com.exa.pesa.core.persistence.daos.parties;

import com.exa.pesa.core.persistence.entitities.parties.JpaUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andres on 9/10/2017.
 */
public interface JpaUserDAO extends CrudRepository<JpaUser, Integer>{

    public JpaUser findByLogin(String login);

}
