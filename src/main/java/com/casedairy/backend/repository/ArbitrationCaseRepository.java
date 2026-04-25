package com.casedairy.backend.repository;

import com.casedairy.backend.model.ArbitrationCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArbitrationCaseRepository extends JpaRepository<ArbitrationCase, Integer> {
}