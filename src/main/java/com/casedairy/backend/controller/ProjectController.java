package com.casedairy.backend.controller;

import com.casedairy.backend.model.Project;
import com.casedairy.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    @Autowired
    private com.casedairy.backend.repository.ClientRepository clientRepo;

    // 🔥 SAVE / UPDATE
    @PostMapping("/save")
    public Project saveProject(@RequestBody Project p) {

        // 🔥 client fetch
        var client = clientRepo.findById(p.getClientId()).orElse(null);

        if (client != null) {
            p.setClientName(client.getName());
            p.setLocation(client.getLocation());
        }

        // 🔴 UPDATE
        if (p.getId() != null) {
            Optional<Project> existing = repo.findById(p.getId());

            if (existing.isPresent()) {
                Project proj = existing.get();

                proj.setClientId(p.getClientId());
                proj.setClientName(p.getClientName());
                proj.setLocation(p.getLocation());
                proj.setProjectName(p.getProjectName());
                proj.setProjectCode(p.getProjectCode());
                proj.setProjectPackage(p.getProjectPackage());

                return repo.save(proj);
            }
        }

        // 🔴 INSERT
        p.setId(null);
        return repo.save(p);
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<Project> getAll() {
        return repo.findAll();
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public Project getById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted Successfully";
        }
        return "Not Found";
    }

    @GetMapping("/byName/{name}")
    public Project getByName(@PathVariable String name) {
        return repo.findByProjectName(name);
    }

    @GetMapping("/byCode/{code}")
    public List<Project> getByCode(@PathVariable String code) {
        return repo.findByProjectCode(code);
    }
}