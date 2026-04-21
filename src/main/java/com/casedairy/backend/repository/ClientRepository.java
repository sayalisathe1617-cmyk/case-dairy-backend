package com.casedairy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casedairy.backend.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNameContaining(String name);

}
