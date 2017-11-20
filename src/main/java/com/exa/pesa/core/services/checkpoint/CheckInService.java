package com.exa.pesa.core.services.checkpoint;

import com.exa.pesa.core.enums.EntryState;
import com.exa.pesa.core.enums.EntryType;
import com.exa.pesa.core.enums.TicketType;
import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.checkpoint.CheckIn;
import com.exa.pesa.core.views.checkpoint.CheckInCreationView;
import com.exa.pesa.core.views.checkpoint.CheckInUpdateView;

import java.util.List;

/**
 * Created by Andres on 26/10/2017.
 */
public interface CheckInService {
    List<CheckIn> getCheckInByState(EntryType entryType, EntryState state, Boolean includeTransit)
            throws BusinessException;

    List<com.exa.pesa.core.model.checkpoint.EntryType> getEntryTypes() throws BusinessException;

    void saveCheckIn(CheckInCreationView creationView) throws BusinessException;

    void updateCheckIn(Integer id, CheckInUpdateView updateView) throws BusinessException;

    void registerCheckinOut(Integer id) throws BusinessException;

    Integer getTicketCodeByType(TicketType type) throws BusinessException;

    CheckIn getCheckInById(Integer id) throws BusinessException;
}
