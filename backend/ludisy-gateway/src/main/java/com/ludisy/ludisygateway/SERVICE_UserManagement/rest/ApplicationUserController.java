package com.ludisy.ludisygateway.SERVICE_UserManagement.rest;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.JwtRequest;
import com.ludisy.ludisygateway.SERVICE_UserManagement.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationUserController {

    @Autowired
    ApplicationUserService applicationUserService;

    @PostMapping("/SERVICE_authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        return applicationUserService.authenticate(authenticationRequest);
    }
}
