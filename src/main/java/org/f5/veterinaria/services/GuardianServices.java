package org.f5.veterinaria.services;

import org.f5.veterinaria.dtos.GuardianRequestDTO;
import org.f5.veterinaria.entities.Guardian;
import org.f5.veterinaria.exceptions.GuardianNotFoundExcepcion;
import org.f5.veterinaria.mappers.GuardianMapper;
import org.f5.veterinaria.repositories.GuardianRepository;
import org.springframework.stereotype.Service;

@Service
public class GuardianServices {
    private final GuardianRepository guardianRepository;

    public GuardianServices(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    public Guardian createGuardian(GuardianRequestDTO guardianRequestDTO) {
        Guardian guardian = GuardianMapper.toEntity(guardianRequestDTO); // Se esta convirtiendo un guardian request en un guardian para guardarlo en el repository
        return guardianRepository.save(guardian);
    }

    public Guardian findById(Long id) {
        return guardianRepository.findById(id)
                .orElseThrow(() -> new GuardianNotFoundExcepcion("Guardian Not Found")); // -> Lanzar la excepción si no se encuentra por id
    }

}
