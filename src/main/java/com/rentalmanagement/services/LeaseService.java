package com.rentalmanagement.services;

import com.rentalmanagement.entities.Lease;
import com.rentalmanagement.entities.Tenant;
import com.rentalmanagement.repositories.LeaseRepository;
import com.rentalmanagement.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;

    @Autowired
    private TenantRepository tenantRepository;

    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    public List<Lease> getLeasesByTenantId(Long tenantId) {
        return leaseRepository.findByTenantId(tenantId);
    }

    public Lease createLease(Lease lease) {
        // Validate tenant exists
        Optional<Tenant> tenant = tenantRepository.findById(lease.getTenant().getId());
        if (!tenant.isPresent()) {
            throw new RuntimeException("Tenant not found");
        }
        
        return leaseRepository.save(lease);
    }

    public Lease updateLease(Long id, Lease leaseDetails) {
        Lease lease = leaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lease not found"));

        lease.setPropertyAddress(leaseDetails.getPropertyAddress());
        lease.setStartDate(leaseDetails.getStartDate());
        lease.setEndDate(leaseDetails.getEndDate());
        lease.setMonthlyRent(leaseDetails.getMonthlyRent());
        lease.setStatus(leaseDetails.getStatus());

        return leaseRepository.save(lease);
    }

    public void deleteLease(Long id) {
        Lease lease = leaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lease not found"));
        leaseRepository.delete(lease);
    }

    public List<Lease> getLeasesByStatus(String status) {
        return leaseRepository.findByStatus(status);
    }
}
