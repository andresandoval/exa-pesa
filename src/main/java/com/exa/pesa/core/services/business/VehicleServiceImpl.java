package com.exa.pesa.core.services.business;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Vehicle;
import com.exa.pesa.core.persistence.daos.business.JpaTransportDAO;
import com.exa.pesa.core.persistence.entitities.business.JpaVehicle;
import com.exa.pesa.core.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private JpaTransportDAO jpaTransportDAO;

    @Override
    public List<Vehicle> getVehicleByPlateFilter(String plate) throws BusinessException {
        plate = Objects.isNull(plate) ? "" : plate;
        Set<JpaVehicle> jpaVehicles = this.jpaTransportDAO.findTop20ByPlateContainingIgnoreCase(plate);
        if (Objects.isNull(jpaVehicles))
            return null;
        final List<Vehicle> vehicles = new ArrayList<>();
        jpaVehicles.stream().forEach(jpaVehicle -> {
            vehicles.add(jpaVehicle.getModel());
        });
        return vehicles;
    }

    @Override
    public Vehicle findVehicleByPlate(String plate) throws BusinessException {
        Asserts.nonNullParams(plate);
        JpaVehicle jpaVehicle = this.jpaTransportDAO.findOne(plate);
        if(Objects.isNull(jpaVehicle))
            return null;
        return jpaVehicle.getModel();
    }
}
