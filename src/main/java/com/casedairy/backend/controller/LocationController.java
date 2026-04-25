package com.casedairy.backend.controller;

import com.casedairy.backend.model.LocationMaster;
import com.casedairy.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // 🔥 IMPORTANT (Flutter Web)
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repo;

    // 🔥 SAVE VILLAGE
    @PostMapping("/save")
    public LocationMaster save(@RequestBody LocationMaster loc) {
        return repo.save(loc);
    }

    // 🔥 GET ALL
    @GetMapping("/all")
    public List<LocationMaster> getAll() {
        return repo.findAll();
    }

    // 🔥 GET BY VILLAGE (for dropdown)
    @GetMapping("/byVillage/{village}")
    public List<LocationMaster> getByVillage(@PathVariable String village) {
        return repo.findAll(); // 🔥 TEST ONLY
    }

    // 🔥 UPDATE
    @PutMapping("/update")
    public LocationMaster update(@RequestBody LocationMaster loc) {

        Optional<LocationMaster> optional = repo.findById(loc.getId());

        if (optional.isPresent()) {

            LocationMaster existing = optional.get();

            existing.setVillage(loc.getVillage());
            existing.setDistrict(loc.getDistrict());
            existing.setTaluka(loc.getTaluka());

            return repo.save(existing); // 🔥 UPDATE
        }

        return null;
    }
    // 🔥 DELETE
    @DeleteMapping("/delete/{village}")
    public void delete(@PathVariable String village) {
        List<LocationMaster> list = repo.findByVillageContaining(village);
        if (!list.isEmpty()) {
            repo.delete(list.get(0));
        }
    }
}