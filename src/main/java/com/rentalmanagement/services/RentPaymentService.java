package com.rentalmanagement.services;

import com.rentalmanagement.entities.RentPayment;
import com.rentalmanagement.entities.Tenant;
import com.rentalmanagement.repositories.RentPaymentRepository;
import com.rentalmanagement.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentPaymentService {
    @Autowired
    private RentPaymentRepository rentPaymentRepository;

    @Autowired
    private TenantRepository tenantRepository;

    public List<RentPayment> getAllPayments() {
        return rentPaymentRepository.findAll();
    }

    public List<RentPayment> getPaymentsByTenantId(Long tenantId) {
        return rentPaymentRepository.findByTenantId(tenantId);
    }

    public RentPayment createPayment(RentPayment payment) {
        // Validate tenant exists
        Optional<Tenant> tenant = tenantRepository.findById(payment.getTenant().getId());
        if (!tenant.isPresent()) {
            throw new RuntimeException("Tenant not found");
        }
        
        return rentPaymentRepository.save(payment);
    }

    public RentPayment updatePayment(Long id, RentPayment paymentDetails) {
        RentPayment payment = rentPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setAmount(paymentDetails.getAmount());
        payment.setPaymentDate(paymentDetails.getPaymentDate());
        payment.setPaymentMethod(paymentDetails.getPaymentMethod());
        payment.setStatus(paymentDetails.getStatus());
        payment.setDueDate(paymentDetails.getDueDate());

        return rentPaymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        RentPayment payment = rentPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        rentPaymentRepository.delete(payment);
    }

    public List<RentPayment> getPaymentsByStatus(String status) {
        return rentPaymentRepository.findByStatus(status);
    }
}
