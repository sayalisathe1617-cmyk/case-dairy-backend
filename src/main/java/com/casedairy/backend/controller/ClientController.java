package com.casedairy.backend.controller;

import com.casedairy.backend.model.Client;
import com.casedairy.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repo;

    // 🔹 SAVE + UPDATE
    @PostMapping("/save")
    public Client saveClient(@RequestBody Client c) {

        // 🔥 अगर ID null असेल → insert
        // 🔥 अगर ID असेल → update
        return repo.save(c);
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<Client> getAllClients() {

        return repo.findAll();
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {

        return repo.findById(id).orElse(null);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    // 🔹 NEXT ID (for UI display)
    @GetMapping("/nextId")
    public int getNextId() {
        List<Client> list = repo.findAll();
        if (list.isEmpty()) return 1;
        return list.get(list.size() - 1).getId() + 1;
    }
}