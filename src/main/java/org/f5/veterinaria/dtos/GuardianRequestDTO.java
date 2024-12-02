package org.f5.veterinaria.dtos;

public record GuardianRequestDTO(
        String name,
        String phone,
        String address,
        String email
) {
}
