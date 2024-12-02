package org.f5.veterinaria.mappers;

import org.f5.veterinaria.dtos.GuardianRequestDTO;
import org.f5.veterinaria.entities.Guardian;

public class GuardianMapper {

    public static Guardian toEntity(GuardianRequestDTO guardianRequestDTO) {
        return new Guardian(guardianRequestDTO.name(), guardianRequestDTO.phone(),
                guardianRequestDTO.email(), guardianRequestDTO.address());
    }
}
