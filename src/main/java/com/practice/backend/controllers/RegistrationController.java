package com.practice.backend.controllers;

import com.practice.backend.models.requestEntities.RegistrationRequest;
import com.practice.backend.models.responseEntities.RegistrationResponse;
import com.practice.backend.services.JwtTokenProviderService;
import com.practice.backend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;
    private final JwtTokenProviderService jwtTokenProviderService;

    @Autowired
    public RegistrationController(RegistrationService registrationService, JwtTokenProviderService jwtTokenProviderService) {
        this.registrationService = registrationService;
        this.jwtTokenProviderService = jwtTokenProviderService;
    }

    @PostMapping("/registration")
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = new RegistrationResponse(registrationService.userRegistration(request));

        if (response.isResult()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.internalServerError().body(response);
    }
}
