package com.exa.pesa.core.controllers.checkpoint;

import com.exa.pesa.core.config.ApplicationConfig;
import com.exa.pesa.core.enums.EntryState;
import com.exa.pesa.core.enums.EntryType;
import com.exa.pesa.core.enums.TicketType;
import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.checkpoint.CheckIn;
import com.exa.pesa.core.persistence.daos.checkpoint.JpaCheckInDAO;
import com.exa.pesa.core.services.checkpoint.CheckInService;
import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.views.MessageView;
import com.exa.pesa.core.views.checkpoint.CheckInCreationView;
import com.exa.pesa.core.views.checkpoint.CheckInUpdateView;
import com.exa.pesa.core.views.checkpoint.CheckInView;
import com.exa.pesa.core.views.checkpoint.EntryTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andres on 21/10/2017.
 */
@RestController
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @Autowired
    private ApplicationConfig applicationConfig;

    @RequestMapping(value = RestEndpoints.CHECK_IN_INPUT_LIST, method = RequestMethod.GET)
    public ResponseEntity<List<CheckInView>> inputList() throws BusinessException {
        List<CheckIn> result = checkInService.getCheckInByState(EntryType.ALL, EntryState.PENDING, false);
        final List<CheckInView> arrivalDepartureViews = new ArrayList<>();
        if (Objects.nonNull(result))
            result.stream().forEach(r -> arrivalDepartureViews.add(new CheckInView(r)));

        return new ResponseEntity<>(arrivalDepartureViews, HttpStatus.OK);
    }

    @RequestMapping(value = RestEndpoints.CHECK_IN_OUTPUT_LIST, method = RequestMethod.GET)
    public ResponseEntity<List<CheckInView>> outputList() throws BusinessException {
        List<CheckIn> result = checkInService.getCheckInByState(EntryType.ALL, EntryState.ENDED, false);
        final List<CheckInView> checkInViews = new ArrayList<>();
        if (Objects.nonNull(result))
            result.stream().forEach(r -> checkInViews.add(new CheckInView(r)));

        return new ResponseEntity<>(checkInViews, HttpStatus.OK);
    }

    @GetMapping(value = RestEndpoints.ENTRY_TYPE_LIST)
    public ResponseEntity<List<EntryTypeView>> entryTypeList() throws BusinessException {
        List<com.exa.pesa.core.model.checkpoint.EntryType> result = checkInService.getEntryTypes();
        final List<EntryTypeView> entryTypeViewList = new ArrayList<>();
        if (Objects.nonNull(result))
            result.stream().forEach(r -> entryTypeViewList.add(new EntryTypeView(r)));

        return new ResponseEntity<>(entryTypeViewList, HttpStatus.OK);
    }

    @PostMapping(value = RestEndpoints.CHECK_IN_SAVE)
    public ResponseEntity<MessageView> saveCheckIn(@RequestBody CheckInCreationView creationView) throws
            BusinessException {
        try {
            this.checkInService.saveCheckIn(creationView);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof BusinessException)
                throw ex;
            return new ResponseEntity<MessageView>(new MessageView("No su pudo registrar la entrada"), HttpStatus
                    .NOT_FOUND);
        }
        return new ResponseEntity<MessageView>(new MessageView("Entrada registrada con exito"), HttpStatus.CREATED);
    }

    private String getTicketCode(TicketType type) throws BusinessException {
        Integer firstPartSize = 3;
        Integer secondPartSize = 6;

        Integer ticketNumber = this.checkInService.getTicketCodeByType(type);
        if (Objects.isNull(ticketNumber))
            ticketNumber = 0;
        String firstPart = String.format("%d", this.applicationConfig.getSiteId());
        String secondPart = String.format("%d", ticketNumber);
        for (int i = firstPart.length(); i < firstPartSize; i++) {
            firstPart = "0" + firstPart;
        }
        for (int i = secondPart.length(); i < secondPartSize; i++) {
            secondPart = "0" + secondPart;
        }
        return String.format("%s-%s", firstPart, secondPart);

    }

    @GetMapping(value = RestEndpoints.CHECK_IN_NEW)
    public ResponseEntity<CheckInView> getNewCheckIn() throws BusinessException {
        CheckInView newInstance = new CheckInView();
        newInstance.setTiketNumber(this.getTicketCode(TicketType.CHECKPOINT));
        newInstance.setLotCode(this.getTicketCode(TicketType.INPUT));
        return new ResponseEntity<CheckInView>(newInstance, HttpStatus.OK);
    }

    @GetMapping(value = RestEndpoints.CHECK_IN_SINGLE)
    public ResponseEntity<CheckInView> getSingleCheckIn(@PathVariable Integer id) throws BusinessException {
        CheckIn checkIn = this.checkInService.getCheckInById(id);
        if (Objects.isNull(checkIn))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new CheckInView(checkIn), HttpStatus.OK);
    }

    @PatchMapping(value = RestEndpoints.CHECK_IN_UPDATE)
    public ResponseEntity<MessageView> updateCheckIn(@PathVariable Integer id, @RequestBody CheckInUpdateView
            updateView) throws
            BusinessException {
        try {
            this.checkInService.updateCheckIn(id, updateView);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof BusinessException)
                throw ex;
            return new ResponseEntity<MessageView>(new MessageView("No su pudo actualizar la entrada"), HttpStatus
                    .NOT_FOUND);
        }
        return new ResponseEntity<MessageView>(new MessageView("Entrada actualizada con exito"), HttpStatus.OK);
    }

    @PutMapping(value = RestEndpoints.CHECK_IN_OUT)
    public ResponseEntity<MessageView> registerCheckInOut(@PathVariable Integer id) throws
            BusinessException {
        try {
            this.checkInService.registerCheckinOut(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof BusinessException)
                throw ex;
            return new ResponseEntity<MessageView>(new MessageView("No se pudo registrar la salida"), HttpStatus
                    .NOT_FOUND);
        }
        return new ResponseEntity<MessageView>(new MessageView("Salida registrada con exito"), HttpStatus.OK);
    }

}
