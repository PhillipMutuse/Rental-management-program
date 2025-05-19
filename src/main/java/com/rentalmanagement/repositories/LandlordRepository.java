package com.rentalmanagement.repositories;

import com.rentalmanagement.entities.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {
    Landlord findByEmail(String email);
    List<Landlord> findByBusinessNameContainingIgnoreCase(String businessName);
}
