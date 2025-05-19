package com.rentalmanagement.repositories;

import com.rentalmanagement.entities.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
    List<MaintenanceRequest> findByTenantId(Long tenantId);
    List<MaintenanceRequest> findByPropertyId(Long propertyId);
    List<MaintenanceRequest> findByStatus(String status);
}
