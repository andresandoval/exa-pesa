package com.exa.pesa.core.persistence.daos.parties;

import com.exa.pesa.core.model.parties.Person;
import com.exa.pesa.core.persistence.entitities.parties.JpaPerson;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by Andres on 22/10/2017.
 */
public interface JpaPersonDAO extends CrudRepository<JpaPerson, String>{

    //@Query("SELECT per FROM JpaPerson per WHERE LOWER(per.name) LIKE CONCAT('%', LOWER(?1), '%')")
    //Pege<JpaPerson> findFilterByName(String name, PageWrapper pageable);

    Set<JpaPerson> findTop20ByNameContainingIgnoreCaseOrderByNameAsc(String name);

}
