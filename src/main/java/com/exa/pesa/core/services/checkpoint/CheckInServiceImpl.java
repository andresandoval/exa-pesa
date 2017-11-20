package com.exa.pesa.core.services.checkpoint;

import com.exa.pesa.core.config.ApplicationConfig;
import com.exa.pesa.core.enums.EntryState;
import com.exa.pesa.core.enums.EntryType;
import com.exa.pesa.core.enums.TicketType;
import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.business.Vehicle;
import com.exa.pesa.core.model.checkpoint.CheckIn;
import com.exa.pesa.core.persistence.daos.checkpoint.JpaCheckInDAO;
import com.exa.pesa.core.persistence.daos.checkpoint.JpaEntryTypeDAO;
import com.exa.pesa.core.persistence.entitities.checkpoint.JpaCheckIn;
import com.exa.pesa.core.persistence.entitities.checkpoint.JpaEntryType;
import com.exa.pesa.core.services.business.VehicleService;
import com.exa.pesa.core.util.Asserts;
import com.exa.pesa.core.views.checkpoint.CheckInCreationView;
import com.exa.pesa.core.views.checkpoint.CheckInUpdateView;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Andres on 26/10/2017.
 */
@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private JpaCheckInDAO checkInDAO;
    @Autowired
    private JpaEntryTypeDAO entryTypeDAO;
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private VehicleService vehicleService;

    @Override
    public List<CheckIn> getCheckInByState(EntryType entryType, EntryState state, Boolean
            includeTransit) throws BusinessException {
        Asserts.nonNullParams(entryType, state, includeTransit);
        List<JpaCheckIn> jpaResult;
        if (entryType.equals(EntryType.ALL))
            jpaResult = checkInDAO.findAllEntriesByState(state.getCode());
        else {
            if (includeTransit)
                jpaResult = checkInDAO.findByStateAndEntryTypeIncludedInTransit(state.getCode(), entryType
                        .getCode());
            else
                jpaResult = checkInDAO.findByStateAndEntryType(state.getCode(), entryType.getCode());
        }
        if (Objects.isNull(jpaResult) || jpaResult.size() <= 0)
            return null;

        final List<CheckIn> result = new ArrayList<>();
        jpaResult.forEach(jpaR -> result.add(jpaR.getModel()));
        return result;
    }

    @Override
    public List<com.exa.pesa.core.model.checkpoint.EntryType> getEntryTypes() throws BusinessException {
        Iterable<JpaEntryType> jpaEntryTypeSet = entryTypeDAO.findAll();
        if (Objects.isNull(jpaEntryTypeSet))
            return null;
        final List<com.exa.pesa.core.model.checkpoint.EntryType> entryTypeList = new ArrayList<>();
        jpaEntryTypeSet.forEach(jpaEntryType -> entryTypeList.add(jpaEntryType.getModel()));
        return entryTypeList;
    }

    @Override
    public void saveCheckIn(CheckInCreationView creationView) throws BusinessException {
        Asserts.nonNullParams(creationView);
        JpaEntryType jpaEntryType = entryTypeDAO.findOne(creationView.getEntryTypeId());
        Asserts.nonNull(jpaEntryType, "El tipo de transaccion no existe");
        Vehicle vehicle = this.vehicleService.findVehicleByPlate(creationView.getVehiclePlate());
        Asserts.nonNull(vehicle, "El vehiculo seleccionado no existe");
        creationView.setDate(new Date());
        creationView.setSiteId(this.applicationConfig.getSiteId());
        creationView.setNoReg(vehicle.getPlate().equals("000-0000"));
        EntryState entryState = EntryState.getStateFromEntryType(jpaEntryType.getId());
        creationView.setState(entryState.getCode());

        String tiketNumber = creationView.getTicketNumber();
        String loteCode = creationView.getLotCode();
        if (Objects.isNull(creationView.getObservation()))
            creationView.setObservation("");

        if (Objects.isNull(creationView.getMeetsConditions()))
            creationView.setMeetsConditions(false);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        this.checkInDAO.saveData(
                creationView.getSiteId(),
                jpaEntryType.getId(),
                creationView.getDate(),
                vehicle.getPlate(),
                creationView.getNoReg(),
                tiketNumber,
                loteCode,
                creationView.getState(),
                true,
                creationView.getObservation(),
                creationView.getMeetsConditions(),
                false,
                username,
                creationView.getCheckpointId()
        );
    }

    @Override
    public void updateCheckIn(Integer id, CheckInUpdateView updateView) throws BusinessException {
        Asserts.nonNullParams(id, updateView);
        CheckIn checkIn = this.getCheckInById(id);
        Asserts.nonNull(checkIn, "El registro no existe");
        JpaEntryType jpaEntryType = entryTypeDAO.findOne(updateView.getEntryTypeId());
        Asserts.nonNull(jpaEntryType, "El tipo de transaccion no existe");
        Vehicle vehicle = this.vehicleService.findVehicleByPlate(updateView.getVehiclePlate());
        Asserts.nonNull(vehicle, "El vehiculo seleccionado no existe");

        updateView.setNoReg(vehicle.getPlate().equals("000-0000"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if (Objects.isNull(updateView.getObservation()))
            updateView.setObservation("");
        if (Objects.isNull(updateView.getMeetsConditions()))
            updateView.setMeetsConditions(false);

        this.checkInDAO.updateData(
                id,
                jpaEntryType.getId(),
                updateView.getTicketNumber(),
                updateView.getLotCode(),
                vehicle.getPlate(),
                updateView.getNoReg(),
                updateView.getObservation(),
                updateView.getMeetsConditions(),
                username
        );

    }

    @Override
    public void registerCheckinOut(Integer id) throws BusinessException {
        Asserts.nonNullParams(id);
        CheckIn checkIn = this.getCheckInById(id);
        Asserts.nonNull(checkIn, "El registro no existe");

        if (Objects.isNull(checkIn.getObservation()))
            checkIn.setObservation("");
        if (Objects.isNull(checkIn.getMeetsConditions()))
            checkIn.setMeetsConditions(false);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        this.checkInDAO.updateState(
                checkIn.getId(),
                -1,
                false,
                "",
                username
        );
    }

    @Override
    public Integer getTicketCodeByType(TicketType type) throws BusinessException {
        Asserts.nonNullParams(type);
        return this.checkInDAO.getNumTiquet(type.getValue());
    }

    @Override
    public CheckIn getCheckInById(Integer id) throws BusinessException {
        JpaCheckIn jpaCheckIn = this.checkInDAO.findOne(id);
        if (Objects.isNull(jpaCheckIn))
            return null;
        return jpaCheckIn.getModel();
    }
}
