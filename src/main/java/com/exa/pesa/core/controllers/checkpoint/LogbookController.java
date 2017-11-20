package com.exa.pesa.core.controllers.checkpoint;

import com.exa.pesa.core.config.ApplicationConfig;
import com.exa.pesa.core.config.ParameterConfig;
import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.PageWrapper;
import com.exa.pesa.core.model.business.Parameter;
import com.exa.pesa.core.model.checkpoint.Logbook;
import com.exa.pesa.core.model.parties.Person;
import com.exa.pesa.core.services.business.ParameterService;
import com.exa.pesa.core.services.checkpoint.LogbookService;
import com.exa.pesa.core.services.parties.PartyService;
import com.exa.pesa.core.util.Asserts;
import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.util.TimeUtils;
import com.exa.pesa.core.views.MessageView;
import com.exa.pesa.core.views.PageWrapperView;
import com.exa.pesa.core.views.checkpoint.LogbookCreationView;
import com.exa.pesa.core.views.checkpoint.LogbookOutView;
import com.exa.pesa.core.views.checkpoint.LogbookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andres on 22/10/2017.
 */
@RestController
public class LogbookController {

    @Autowired
    private LogbookService logbookService;
    @Autowired
    private ParameterService parameterService;
    @Autowired
    private ApplicationConfig appConfig;
    @Autowired
    private ParameterConfig parameterConfig;
    @Autowired
    private PartyService partyService;

    @GetMapping(value = RestEndpoints.LOGBOOK_LIST)
    private ResponseEntity<PageWrapperView> listLogBook(@RequestParam(required = true) Integer page, @RequestParam
            (required = true) Integer size, @RequestParam(required = true) String filter) throws
            BusinessException {
        PageWrapper<Logbook> modelResult = logbookService.listAll(appConfig.getSiteId(), page, size, filter);
        PageWrapperView<LogbookView> viewResult = new PageWrapperView<>();

        if (Objects.nonNull(modelResult)) {
            viewResult.setTotalItems(modelResult.getTotalItems());
            viewResult.setNumOfPages(modelResult.getNumOfPages());
            viewResult.setPageSize(modelResult.getPageSize());
            final List<LogbookView> logbookViewList = new ArrayList<>();
            modelResult.getPageContent().stream().forEach(logbook -> {
                logbookViewList.add(new LogbookView(logbook));
            });
            viewResult.setPageContent(logbookViewList);
        }
        return new ResponseEntity<>(viewResult, HttpStatus.OK);
    }

    @GetMapping(value = RestEndpoints.LOGBOOK_SINGLE)
    private ResponseEntity<LogbookView> getLogbookById(@PathVariable(required = true) Integer id) throws
            BusinessException {
        Logbook logbook = this.logbookService.getById(id);
        if (Objects.isNull(logbook))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new LogbookView(logbook), HttpStatus.OK);

    }

    @PostMapping(value = RestEndpoints.LOGBOOK_SAVE)
    private ResponseEntity<MessageView> saveLogbook(@RequestBody LogbookCreationView creationView) throws
            BusinessException {
        Asserts.nonNull(creationView, "Error interno al procesar la consulta");

        Logbook model = new Logbook();
        model.setSiteId(this.appConfig.getSiteId());
        model.setInputDate(TimeUtils.isoStringToLocalDateTime(creationView.getInputDate()));
        model.setName(creationView.getName());

        Parameter inputReazon = parameterService.getParameterById(creationView.getInputReasonId(), parameterConfig
                .getInputTypeGroup());
        Asserts.nonNull(inputReazon, "El motivo de entrada seleccionado no existe");
        model.setInputReason(inputReazon);

        Parameter materialType = parameterService.getParameterById(creationView.getMaterialTypeId(), parameterConfig
                .getMaterialTypeGroup());
        Asserts.nonNull(materialType, "la clase de material seleccionada");
        model.setMaterialType(materialType);

        Parameter vehicleType = parameterService.getParameterById(creationView.getVehicleTypeId(), parameterConfig
                .getVehicleTypeGroup());
        Asserts.nonNull(vehicleType, "El tipo de vehiclo seleccionado no existe");
        model.setVehicleType(vehicleType);

        if (!vehicleType.getId().equals("0")) {
            model.setVehiclePlate(creationView.getVehiclePlate());

            Parameter vehicleColor = parameterService.getParameterById(creationView.getVehicleColorId(), parameterConfig
                    .getColorGroup());
            Asserts.nonNull(vehicleColor, "El color seleccionado no existe");
            model.setVehicleColor(vehicleColor);
        }
        if (Objects.nonNull(creationView.getContactPersonId())) {
            Person contactPerson = this.partyService.getPersonById(creationView.getContactPersonId());
            Asserts.nonNull(contactPerson, "La persona de contacto seleccionada no existe");
            model.setContactPerson(contactPerson);
        }

        Parameter area = parameterService.getParameterById(creationView.getAreaId(), parameterConfig
                .getAreaGroup());
        Asserts.nonNull(vehicleType, "El area seleccionada no existe");
        model.setArea(area);
        model.setObservation(creationView.getObservation());
        Logbook newModel = this.logbookService.save(model);
        if (Objects.isNull(newModel))
            return new ResponseEntity<MessageView>(new MessageView("No se pudo crear la bitacora"), HttpStatus
                    .NOT_FOUND);
        return new ResponseEntity<MessageView>(new MessageView("Bitacora creada con exito"), HttpStatus.CREATED);
    }

    @PatchMapping(value = RestEndpoints.LOGBOOK_OUT)
    private ResponseEntity<MessageView> registerLogbookOut(@PathVariable(required = true) Integer id, @RequestBody
            LogbookOutView
            outView) throws
            BusinessException {
        Asserts.nonNull(outView, "Error interno al procesar la consulta");
        Logbook logbook = this.logbookService.getById(id);
        Asserts.nonNull(logbook, "No se encontro el registro #" + id);

        logbook.setOutputDate(TimeUtils.isoStringToLocalDateTime(outView.getOutputDate()));
        Parameter outputReazon = parameterService.getParameterById(outView.getOutputReasonId(), parameterConfig
                .getOutputTypeGroup());
        Asserts.nonNull(outputReazon, "El motivo de salida seleccionado no existe");
        logbook.setOutputReason(outputReazon);
        String inputObs = logbook.getObservation();
        logbook.setObservation(String.format("ENTRADA: %s\nSALIDA: %s", inputObs, outView.getObservation()));

        Logbook updatedLogbook = this.logbookService.save(logbook);
        if (Objects.isNull(updatedLogbook))
            return new ResponseEntity<MessageView>(new MessageView("No se pudo registrar la salida"), HttpStatus
                    .NOT_FOUND);
        return new ResponseEntity<MessageView>(new MessageView("Se registró la salida con exito"), HttpStatus.CREATED);
    }

}
