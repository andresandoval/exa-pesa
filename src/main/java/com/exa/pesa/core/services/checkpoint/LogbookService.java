package com.exa.pesa.core.services.checkpoint;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.PageWrapper;
import com.exa.pesa.core.model.checkpoint.Logbook;

/**
 * Created by Andres on 22/10/2017.
 */
public interface LogbookService {
    Logbook getById(Integer id) throws BusinessException;
    Logbook save(Logbook logbook) throws BusinessException;
    PageWrapper<Logbook> listAll(Integer siteId, Integer page, Integer size, String filter) throws BusinessException;
}
