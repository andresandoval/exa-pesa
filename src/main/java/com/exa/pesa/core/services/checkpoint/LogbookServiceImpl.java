package com.exa.pesa.core.services.checkpoint;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.PageWrapper;
import com.exa.pesa.core.model.checkpoint.Logbook;
import com.exa.pesa.core.persistence.daos.checkpoint.JpaLogbookDAO;
import com.exa.pesa.core.persistence.entitities.checkpoint.JpaLogbook;
import com.exa.pesa.core.util.Asserts;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andres on 26/10/2017.
 */
@Service
public class LogbookServiceImpl implements LogbookService {

    @Autowired
    private JpaLogbookDAO logBookDAO;

    @Override
    public Logbook getById(Integer id) throws BusinessException {
        Asserts.nonNullParams(id);
        JpaLogbook jpaLogbook = this.logBookDAO.findOne(id);
        if (Objects.isNull(jpaLogbook))
            return null;
        return jpaLogbook.getModel();
    }

    @Override
    public Logbook save(Logbook logbook) throws BusinessException {
        Asserts.nonNullParams(logbook);
        JpaLogbook jpaLogbook = new JpaLogbook(logbook);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (Objects.nonNull(jpaLogbook.getId())) {
            jpaLogbook.setModificationUser(username);
            jpaLogbook.setModificationDate(LocalDateTime.now());
        } else {
            jpaLogbook.setCreationUser(username);
            jpaLogbook.setCreationDate(LocalDateTime.now());
        }
        JpaLogbook savedJpaLogbook = this.logBookDAO.save(jpaLogbook);
        return Objects.isNull(savedJpaLogbook) ? null : savedJpaLogbook.getModel();
    }

    @Override
    public PageWrapper<Logbook> listAll(Integer siteId, Integer page, Integer size, String filter) throws
            BusinessException {
        Asserts.nonNullParams(siteId, page, size);
        final Pageable pageable = new PageRequest(page, size);
        if (Objects.isNull(filter))
            filter = "";
        Page<JpaLogbook> jpaLogbookPage = logBookDAO.findBySiteIdAndNameContainingIgnoreCaseOrderByInputDateDesc
                (siteId, filter, pageable);
        if (Objects.nonNull(jpaLogbookPage) && jpaLogbookPage.getNumberOfElements() <= 0)
            return null;

        final List<Logbook> logbookList = new ArrayList<>();
        jpaLogbookPage.getContent().stream().forEach(jpaL -> {
            logbookList.add(jpaL.getModel());
        });
        return new PageWrapper<>(jpaLogbookPage.getTotalElements(), jpaLogbookPage.getTotalPages(), jpaLogbookPage
                .getNumberOfElements(), logbookList);

    }


}
