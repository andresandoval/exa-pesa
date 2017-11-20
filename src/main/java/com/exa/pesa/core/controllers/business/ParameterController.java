package com.exa.pesa.core.controllers.business;

import com.exa.pesa.core.config.ParameterConfig;
import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Parameter;
import com.exa.pesa.core.services.business.ParameterService;
import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.views.business.ParameterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andres on 22/10/2017.
 */
@RestController
public class ParameterController {

    @Autowired
    private ParameterConfig paramConfig;
    @Autowired
    private ParameterService parameterService;

    private ResponseEntity<List<ParameterView>> getParamsByType(String group) throws BusinessException {
        List<Parameter> parameters = parameterService.getParameterByGroup(group);
        final List<ParameterView> viewResult = new ArrayList<>();
        if (Objects.nonNull(parameters))
            parameters.stream().forEach(parameter -> viewResult.add(new ParameterView(parameter)));
        return new ResponseEntity<>(viewResult, HttpStatus.OK);
    }

    @GetMapping(value = RestEndpoints.PARAMETERS_INPUT_TYPES)
    private ResponseEntity<List<ParameterView>> getInputTypes() throws BusinessException {
        return this.getParamsByType(paramConfig.getInputTypeGroup());
    }

    @GetMapping(value = RestEndpoints.PARAMETERS_OUTPUT_TYPES)
    private ResponseEntity<List<ParameterView>> getOutputTypes() throws BusinessException {
        return this.getParamsByType(paramConfig.getOutputTypeGroup());
    }

    @GetMapping(value = RestEndpoints.PARAMETERS_VEHICLE_TYPES)
    private ResponseEntity<List<ParameterView>> getTransportTypes() throws BusinessException {
        return this.getParamsByType(paramConfig.getVehicleTypeGroup());
    }

    @GetMapping(value = RestEndpoints.PARAMETERS_COLORS)
    private ResponseEntity<List<ParameterView>> getColors() throws BusinessException {
        return this.getParamsByType(paramConfig.getColorGroup());
    }

    @GetMapping(value = RestEndpoints.PARAMETERS_AREAS)
    private ResponseEntity<List<ParameterView>> getAreas() throws BusinessException {
        return this.getParamsByType(paramConfig.getAreaGroup());
    }

    @GetMapping(value = RestEndpoints.PARAMETERS_MATERIAL_TYPES)
    private ResponseEntity<List<ParameterView>> getMaterialTypes() throws BusinessException {
        return this.getParamsByType(paramConfig.getMaterialTypeGroup());
    }

}
