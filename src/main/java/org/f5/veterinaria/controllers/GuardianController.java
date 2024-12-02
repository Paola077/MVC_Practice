package org.f5.veterinaria.controllers;

import org.f5.veterinaria.dtos.GuardianRequestDTO;
import org.f5.veterinaria.entities.Guardian;
import org.f5.veterinaria.services.GuardianServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guardians")
public class GuardianController {

    private final GuardianServices guardianServices;

    public GuardianController(GuardianServices guardianServices) {
        this.guardianServices = guardianServices;
    }

    @PostMapping
    public ResponseEntity<Guardian> createGuardian(@RequestBody GuardianRequestDTO guardianRequestDTO) {
        Guardian guardian = guardianServices.createGuardian(guardianRequestDTO);
        return new ResponseEntity<>(guardian,HttpStatus.CREATED);
    }
}
