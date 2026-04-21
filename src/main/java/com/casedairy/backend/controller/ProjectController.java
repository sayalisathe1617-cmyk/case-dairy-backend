package com.casedairy.backend.controller;

import com.casedairy.backend.model.Project;
import com.casedairy.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    @PostMapping("/addProject")
    public Project addProject(@RequestBody Project project) {
        return repo.save(project);
    }

    @GetMapping("/getProjects")
    public List<Project> getAll() {
        return repo.findAll();
    }
}