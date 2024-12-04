package org.f5.veterinaria.services;

import org.f5.veterinaria.dtos.GuardianRequestDTO;
import org.f5.veterinaria.entities.Guardian;
import org.f5.veterinaria.repositories.GuardianRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GuardianServicesTest {

    @Mock
    GuardianRepository guardianRepository;

    @Test
    void shoud_createAValidGuardian() {
        // Given

        GuardianRequestDTO guardianRequestDTO = new GuardianRequestDTO("some-name", "234567876", "some-addres", "some@email.com");
        GuardianServices guardianServices = new GuardianServices(guardianRepository);
        Guardian guardianToSave = new Guardian("some-name", "234567876", "some-addres", "some@email.com");

        //Mock
        Guardian expectedGuardian = new Guardian(1L,"some-name", "234567876", "some-addres", "some@email.com");
        Mockito.when(guardianRepository.save(any(Guardian.class))).thenReturn(expectedGuardian);

        //When
        //Aqui iria el GuardianResponseDTO
        Guardian guardianResponse = guardianServices.createGuardian(guardianRequestDTO);

        //Then
        verify(guardianRepository).save(guardianToSave);
        assertEquals(expectedGuardian, guardianResponse);
    }
}