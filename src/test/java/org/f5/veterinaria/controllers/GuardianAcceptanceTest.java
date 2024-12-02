package org.f5.veterinaria.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuardianAcceptanceTest {

    //Test de aceptación va desde la api -> DB y lo que devuelve la -> db

    @Autowired
    MockMvc mockMvc;

    @Test
    void createAGuardian() throws Exception {

        String guardianRequest = """
                {
                  "name": "Alice Johnson",
                  "email": "alice.johnson@email.com",
                  "phone": "987654321",
                  "address": "123 Meadow Lane"
                }
                """;

        String responseGuardian = """
                {
                   "id": 1,
                   "name": "Alice Johnson",
                   "email": "alice.johnson@email.com",
                   "phone": "987654321",
                   "address": "123 Meadow Lane"
                 }
                """;

        mockMvc.perform(post("/guardians")
                .contentType(MediaType.APPLICATION_JSON)
                .content(guardianRequest))
                .andExpect(status().isCreated());
    }

}