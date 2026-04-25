package com.casedairy.backend.controller;

import com.casedairy.backend.model.ArbitrationCase;
import com.casedairy.backend.repository.ArbitrationCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cases")
public class ArbitrationCaseController {

    @Autowired
    private ArbitrationCaseRepository repo;

    // 🔥 SAVE
    @PostMapping
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
        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Case not found"));
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "Case deleted successfully";
    }

    @PutMapping("/{id}")
    public ArbitrationCase update(@PathVariable int id, @RequestBody ArbitrationCase c) {

        ArbitrationCase existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));

        existing.setCaseNo(c.getCaseNo());
        existing.setYear(c.getYear());
        existing.setProjectName(c.getProjectName());

        return repo.save(existing);
    }
}