package com.rentalmanagement.services;

import com.rentalmanagement.entities.Property;
import com.rentalmanagement.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public List<Property> searchProperties(String query) {
        return propertyRepository.findByAddressContainingIgnoreCase(query);
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateProperty(Long id, Property propertyDetails) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setAddress(propertyDetails.getAddress());
        property.setCity(propertyDetails.getCity());
        property.setState(propertyDetails.getState());
        property.setZipCode(propertyDetails.getZipCode());
        property.setDescription(propertyDetails.getDescription());
        property.setNumberOfUnits(propertyDetails.getNumberOfUnits());
        property.setAmenities(propertyDetails.getAmenities());
        property.setStatus(propertyDetails.getStatus());

        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        propertyRepository.delete(property);
    }
}
