package com.rentalmanagement.repositories;

import com.rentalmanagement.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByAddressContainingIgnoreCase(String address);
    List<Property> findByCityContainingIgnoreCase(String city);
    List<Property> findByStateContainingIgnoreCase(String state);
    List<Property> findByZipCodeContainingIgnoreCase(String zipCode);
}
