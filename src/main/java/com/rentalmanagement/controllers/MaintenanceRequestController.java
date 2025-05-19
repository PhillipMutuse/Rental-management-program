package com.rentalmanagement.controllers;

import com.rentalmanagement.entities.MaintenanceRequest;
import com.rentalmanagement.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-requests")
public class MaintenanceRequestController {
    @Autowired
    private MaintenanceRequestService maintenanceRequestService;

    @GetMapping
    public List<MaintenanceRequest> getAllRequests() {
        return maintenanceRequestService.getAllRequests();
    }

    @GetMapping("/tenant/{tenantId}")
    public List<MaintenanceRequest> getRequestsByTenantId(@PathVariable Long tenantId) {
        return maintenanceRequestService.getRequestsByTenantId(tenantId);
    }

    @GetMapping("/property/{propertyId}")
    public List<MaintenanceRequest> getRequestsByPropertyId(@PathVariable Long propertyId) {
        return maintenanceRequestService.getRequestsByPropertyId(propertyId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceRequest> getRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceRequestService.getRequestById(id).orElseThrow());
    }

    @PostMapping
    public MaintenanceRequest createRequest(@RequestBody MaintenanceRequest request) {
        return maintenanceRequestService.createRequest(request);
    }

    @PutMapping("/{id}")
    public MaintenanceRequest updateRequest(@PathVariable Long id, @RequestBody MaintenanceRequest requestDetails) {
        return maintenanceRequestService.updateRequest(id, requestDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        maintenanceRequestService.deleteRequest(id);
    }
}
