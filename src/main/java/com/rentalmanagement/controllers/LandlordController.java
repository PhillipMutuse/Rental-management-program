package com.rentalmanagement.controllers;

import com.rentalmanagement.entities.Landlord;
import com.rentalmanagement.services.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landlords")
public class LandlordController {
    @Autowired
    private LandlordService landlordService;

    @GetMapping
    public List<Landlord> getAllLandlords() {
        return landlordService.getAllLandlords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Landlord> getLandlordById(@PathVariable Long id) {
        return ResponseEntity.ok(landlordService.getLandlordById(id).orElseThrow());
    }

    @PostMapping
    public Landlord createLandlord(@RequestBody Landlord landlord) {
        return landlordService.createLandlord(landlord);
    }

    @PutMapping("/{id}")
    public Landlord updateLandlord(@PathVariable Long id, @RequestBody Landlord landlordDetails) {
        return landlordService.updateLandlord(id, landlordDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLandlord(@PathVariable Long id) {
        landlordService.deleteLandlord(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Landlord> getLandlordByEmail(@PathVariable String email) {
        return ResponseEntity.ok(landlordService.findByEmail(email));
    }
}
