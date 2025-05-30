package com.rentalmanagement.repositories;

import com.rentalmanagement.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    List<Unit> findByPropertyId(Long propertyId);
    List<Unit> findByStatus(String status);
    List<Unit> findByUnitNumber(String unitNumber);
}
