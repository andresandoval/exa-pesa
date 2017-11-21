package com.exa.pesa.core.controllers.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {

    @RequestMapping("/")
    public String home() {
        return "/index.html";
    }

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String forward() {
        // Forward to home page so that route is preserved.
        return "forward:/";
    }
}
