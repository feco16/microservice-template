package com.ludisy.ludisygateway.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class GatewayController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome at Ludisy!";
    }

    @GetMapping("/secure")
    public String secure() {
        return "Secured page!";
    }

}
