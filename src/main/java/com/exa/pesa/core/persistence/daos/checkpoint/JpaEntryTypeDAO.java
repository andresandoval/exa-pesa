package com.exa.pesa.core.persistence.daos.checkpoint;

import com.exa.pesa.core.persistence.entitities.checkpoint.JpaEntryType;
import org.springframework.data.repository.CrudRepository;

public interface JpaEntryTypeDAO extends CrudRepository<JpaEntryType, Integer> {
}
