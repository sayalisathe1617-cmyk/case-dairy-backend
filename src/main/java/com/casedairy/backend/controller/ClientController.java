package com.casedairy.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.casedairy.backend.model.Client;
import com.casedairy.backend.repository.ClientRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repo;

    // 🔥 SAVE OR UPDATE CLIENT
    @PostMapping("/save")
    public Client saveClient(@RequestBody Client c) {

        try {

            // ✅ VALIDATION
            if (c.getName() == null || c.getName().trim().isEmpty() ||
                    c.getAddress() == null || c.getAddress().trim().isEmpty() ||
                    c.getLocation() == null || c.getLocation().trim().isEmpty()) {

                throw new RuntimeException("Required fields missing");
            }

            // ✅ UPDATE
            if (c.getId() != null) {

                Optional<Client> optional = repo.findById(c.getId());

                if (optional.isPresent()) {
                    Client existing = optional.get();

                    existing.setName(c.getName());
                    existing.setAddress(c.getAddress());
                    existing.setLocation(c.getLocation());
                    existing.setContactName(c.getContactName());
                    existing.setContactNumber(c.getContactNumber());
                    existing.setEmail(c.getEmail());

                    return repo.save(existing);
                }
            }

            // ✅ INSERT (AUTO ID)
            c.setId(null); // 🔥 IMPORTANT
            return repo.save(c);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving client");
        }
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // 🔹 GET ALL
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return repo.findAll();
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable int id) {

        try {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return "Deleted Successfully";
            } else {
                return "Client Not Found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while deleting";
        }
    }

    // 🔹 NEXT ID (OPTIONAL)
    @GetMapping("/nextId")
    public int getNextId() {
        List<Client> list = repo.findAll();
        if (list.isEmpty()) return 1;
        return list.get(list.size() - 1).getId() + 1;
    }
}