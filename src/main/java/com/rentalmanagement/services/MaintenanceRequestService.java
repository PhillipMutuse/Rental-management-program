package com.rentalmanagement.services;

import com.rentalmanagement.entities.MaintenanceRequest;
import com.rentalmanagement.repositories.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestService {
    @Autowired
    private MaintenanceRequestRepository maintenanceRequestRepository;

    public List<MaintenanceRequest> getAllRequests() {
        return maintenanceRequestRepository.findAll();
    }

    public List<MaintenanceRequest> getRequestsByTenantId(Long tenantId) {
        return maintenanceRequestRepository.findByTenantId(tenantId);
    }

    public List<MaintenanceRequest> getRequestsByPropertyId(Long propertyId) {
        return maintenanceRequestRepository.findByPropertyId(propertyId);
    }

    public Optional<MaintenanceRequest> getRequestById(Long id) {
        return maintenanceRequestRepository.findById(id);
    }

    public MaintenanceRequest createRequest(MaintenanceRequest request) {
        return maintenanceRequestRepository.save(request);
    }

    public MaintenanceRequest updateRequest(Long id, MaintenanceRequest requestDetails) {
        MaintenanceRequest request = maintenanceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setTitle(requestDetails.getTitle());
        request.setDescription(requestDetails.getDescription());
        request.setStatus(requestDetails.getStatus());
        request.setCompletedAt(requestDetails.getCompletedAt());

        return maintenanceRequestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        MaintenanceRequest request = maintenanceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        maintenanceRequestRepository.delete(request);
    }
}
