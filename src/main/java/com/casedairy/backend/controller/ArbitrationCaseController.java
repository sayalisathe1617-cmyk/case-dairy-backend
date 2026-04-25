package com.casedairy.backend.controller;

import com.casedairy.backend.model.ArbitrationCase;
import com.casedairy.backend.repository.ArbitrationCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/arbitration")
public class ArbitrationCaseController {

    @Autowired
    private ArbitrationCaseRepository repo;

    // 🔥 SAVE
    @PostMapping("/save")
    public ArbitrationCase save(@RequestBody ArbitrationCase c) {

        try {
            if (c.getCaseNo() == null || c.getCaseNo().isEmpty()) {
                throw new RuntimeException("Case No required");
            }

            return repo.save(c);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving case");
        }
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<ArbitrationCase> getAll() {
        return repo.findAll();
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public ArbitrationCase getById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted";
    }
}