package org.andarworld.maineducationservice.persistence.repository;

import org.andarworld.maineducationservice.persistence.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Integer> {
    Optional<University> findByUuid(String uuid);
}