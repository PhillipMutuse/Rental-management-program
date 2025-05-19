package com.rentalmanagement.services;

import com.rentalmanagement.entities.Landlord;
import com.rentalmanagement.repositories.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordService {
    @Autowired
    private LandlordRepository landlordRepository;

    public List<Landlord> getAllLandlords() {
        return landlordRepository.findAll();
    }

    public Optional<Landlord> getLandlordById(Long id) {
        return landlordRepository.findById(id);
    }

    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

    public Landlord updateLandlord(Long id, Landlord landlordDetails) {
        Landlord landlord = landlordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Landlord not found"));

        landlord.setFirstName(landlordDetails.getFirstName());
        landlord.setLastName(landlordDetails.getLastName());
        landlord.setEmail(landlordDetails.getEmail());
        landlord.setPhoneNumber(landlordDetails.getPhoneNumber());
        landlord.setBusinessName(landlordDetails.getBusinessName());
        landlord.setBusinessAddress(landlordDetails.getBusinessAddress());

        return landlordRepository.save(landlord);
    }

    public void deleteLandlord(Long id) {
        Landlord landlord = landlordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Landlord not found"));
        landlordRepository.delete(landlord);
    }

    public Landlord findByEmail(String email) {
        return landlordRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Landlord not found"));
    }
}
