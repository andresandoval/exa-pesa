package com.exa.pesa.core.persistence.daos.business;

import com.exa.pesa.core.persistence.entitities.business.JpaVehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface JpaTransportDAO extends CrudRepository<JpaVehicle, String>{

    Set<JpaVehicle> findTop20ByPlateContainingIgnoreCase(String plate);
}
