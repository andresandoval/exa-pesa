package com.exa.pesa.core.controllers.parties;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.parties.Person;
import com.exa.pesa.core.services.parties.PartyService;
import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.views.parties.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andres on 22/10/2017.
 */
@RestController
public class PersonController {

    @Autowired
    private PartyService partyService;

    @RequestMapping(value = RestEndpoints.PARTIES_PERSON_NAME_FILTER, method = RequestMethod.GET)
    private ResponseEntity<List<PersonView>> getPersonByNameFilter(@RequestParam(value = "name") String name) throws
            BusinessException {
        List<Person> modelResult = partyService.getPersonByNameFilter(name);
        final List<PersonView> viewResult = new ArrayList<>();
        if (Objects.nonNull(modelResult))
            modelResult.stream().forEach(mr -> viewResult.add(new PersonView(mr)));
        return new ResponseEntity<>(viewResult, HttpStatus.OK);
    }

}
