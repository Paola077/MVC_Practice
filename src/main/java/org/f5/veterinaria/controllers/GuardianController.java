package org.f5.veterinaria.controllers;

import lombok.Getter;
import org.f5.veterinaria.dtos.GuardianRequestDTO;
import org.f5.veterinaria.entities.Guardian;
import org.f5.veterinaria.services.GuardianServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Guard;

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

    @GetMapping("/{id}")
    public ResponseEntity<Guardian> findbyId(@PathVariable Long id) {
        Guardian guardian = guardianServices.findById(id);
        return new ResponseEntity<Guardian>(guardian, HttpStatus.OK);
    }
}
