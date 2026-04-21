package com.casedairy.backend.controller;

import com.casedairy.backend.model.NHAICase;
import com.casedairy.backend.repository.NHAICaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class NHAICaseController {

    @Autowired
    private NHAICaseRepository repo;

    // 🔹 SAVE
    @PostMapping("/addCase")
    public NHAICase addCase(@RequestBody NHAICase caseData) {
        return repo.save(caseData);
    }

    // 🔹 GET ALL
    @GetMapping("/getCases")
    public List<NHAICase> getAllCases() {
        return repo.findAll();
    }
}