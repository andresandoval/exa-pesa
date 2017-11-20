package com.exa.pesa.core.services.business;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getVehicleByPlateFilter(String plate) throws BusinessException;

    Vehicle findVehicleByPlate(String plate) throws BusinessException;

}
