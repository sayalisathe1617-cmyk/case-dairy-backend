package com.casedairy.backend.controller;

import com.casedairy.backend.model.ArbitrationCase;
import com.casedairy.backend.repository.ArbitrationCaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // 🔥 IMPORTANT (Flutter Web)
@RequestMapping("/arbitration")
public class ArbitrationCaseController {

    @Autowired
    private ArbitrationCaseRepository repo;

    // 🔥 SAVE
    @PostMapping("/save")
    public ArbitrationCase save(@RequestBody ArbitrationCase c) {

        if (c.getCaseNo() == null || c.getCaseNo().isEmpty()) {
            throw new RuntimeException("Case No required");
        }

        return repo.save(c);
    }

    // 🔥 GET ALL
    @GetMapping("/all")
    public List<ArbitrationCase> getAll() {
        return repo.findAll();
    }

    // 🔥 GET BY ID
    @GetMapping("/{id}")
    public ArbitrationCase getById(@PathVariable int id) {

        Optional<ArbitrationCase> optional = repo.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    // 🔥 UPDATE
    @PutMapping("/update")
    public ArbitrationCase update(@RequestBody ArbitrationCase c) {

        Optional<ArbitrationCase> optional = repo.findById(c.getId());

        if (optional.isPresent()) {

            ArbitrationCase existing = optional.get();

            existing.setCaseNo(c.getCaseNo());
            // 👉 इथे बाकी fields पण add कर (year, projectName, etc.)

            return repo.save(existing); // 🔥 UPDATE
        }

        return null;
    }

    // 🔥 DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {

        Optional<ArbitrationCase> optional = repo.findById(id);

        if (optional.isPresent()) {
            repo.delete(optional.get());
        }
    }
}