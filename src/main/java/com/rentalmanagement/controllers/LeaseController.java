package com.rentalmanagement.controllers;

import com.rentalmanagement.entities.Lease;
import com.rentalmanagement.services.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;

    @GetMapping
    public List<Lease> getAllLeases() {
        return leaseService.getAllLeases();
    }

    @GetMapping("/tenant/{tenantId}")
    public List<Lease> getLeasesByTenantId(@PathVariable Long tenantId) {
        return leaseService.getLeasesByTenantId(tenantId);
    }

    @PostMapping
    public Lease createLease(@RequestBody Lease lease) {
        return leaseService.createLease(lease);
    }

    @PutMapping("/{id}")
    public Lease updateLease(@PathVariable Long id, @RequestBody Lease leaseDetails) {
        return leaseService.updateLease(id, leaseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLease(@PathVariable Long id) {
        leaseService.deleteLease(id);
    }

    @GetMapping("/status/{status}")
    public List<Lease> getLeasesByStatus(@PathVariable String status) {
        return leaseService.getLeasesByStatus(status);
    }
}
