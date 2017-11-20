package com.exa.pesa.core.controllers.business;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Vehicle;
import com.exa.pesa.core.services.business.VehicleService;
import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.views.business.VehicleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = RestEndpoints.VEHICLES_PLATE_FILTER)
    private ResponseEntity<List<VehicleView>> getVehicleByPlateFilter(@RequestParam(required = false,
            defaultValue = "") String plate) throws BusinessException {
        List<Vehicle> vehicles = this.vehicleService.getVehicleByPlateFilter(plate);
        final List<VehicleView> vehicleViews = new ArrayList<>();
        if (Objects.nonNull(vehicles))
            vehicles.stream().forEach(transport -> vehicleViews.add(new VehicleView(transport)));
        return new ResponseEntity<>(vehicleViews, HttpStatus.OK);
    }
}
