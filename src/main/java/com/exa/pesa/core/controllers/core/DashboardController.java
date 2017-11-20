package com.exa.pesa.core.controllers.core;

import com.exa.pesa.core.util.RestEndpoints;
import com.exa.pesa.core.views.MessageView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping(value = RestEndpoints.PRIVATE_PING)
    private ResponseEntity<MessageView> privatePing() {
        return new ResponseEntity<>(new MessageView("OK"), HttpStatus.OK);
    }

}
