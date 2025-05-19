package com.rentalmanagement.repositories;

import com.rentalmanagement.entities.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentPaymentRepository extends JpaRepository<RentPayment, Long> {
    List<RentPayment> findByTenantId(Long tenantId);
    List<RentPayment> findByStatus(String status);
}
