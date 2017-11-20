package com.exa.pesa.core.persistence.daos.checkpoint;

import com.exa.pesa.core.persistence.entitities.checkpoint.JpaLogbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by Andres on 22/10/2017.
 */
public interface JpaLogbookDAO extends CrudRepository<JpaLogbook, Integer> {

    Page<JpaLogbook> findBySiteIdAndNameContainingIgnoreCaseOrderByInputDateDesc(Integer siteId, String filter, Pageable pageable);

}
