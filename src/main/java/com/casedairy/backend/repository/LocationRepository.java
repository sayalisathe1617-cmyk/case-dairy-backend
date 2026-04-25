package com.casedairy.backend.repository;

import com.casedairy.backend.model.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationMaster, Integer> {
    List<LocationMaster> findByVillageContaining(String village);
}