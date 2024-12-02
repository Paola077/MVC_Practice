package org.f5.veterinaria.repositories;

import org.f5.veterinaria.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}
