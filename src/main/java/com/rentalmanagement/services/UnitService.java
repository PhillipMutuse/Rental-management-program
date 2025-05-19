package com.rentalmanagement.services;

import com.rentalmanagement.entities.Unit;
import com.rentalmanagement.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public List<Unit> getUnitsByPropertyId(Long propertyId) {
        return unitRepository.findByPropertyId(propertyId);
    }

    public Optional<Unit> getUnitById(Long id) {
        return unitRepository.findById(id);
    }

    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit updateUnit(Long id, Unit unitDetails) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        unit.setUnitNumber(unitDetails.getUnitNumber());
        unit.setNumberOfBedrooms(unitDetails.getNumberOfBedrooms());
        unit.setNumberOfBathrooms(unitDetails.getNumberOfBathrooms());
        unit.setMonthlyRent(unitDetails.getMonthlyRent());
        unit.setStatus(unitDetails.getStatus());
        unit.setCurrentTenant(unitDetails.getCurrentTenant());

        return unitRepository.save(unit);
    }

    public void deleteUnit(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
        unitRepository.delete(unit);
    }
}
