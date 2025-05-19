package com.rentalmanagement.controllers;

import com.rentalmanagement.entities.RentPayment;
import com.rentalmanagement.services.RentPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class RentPaymentController {
    @Autowired
    private RentPaymentService rentPaymentService;

    @GetMapping
    public List<RentPayment> getAllPayments() {
        return rentPaymentService.getAllPayments();
    }

    @GetMapping("/tenant/{tenantId}")
    public List<RentPayment> getPaymentsByTenantId(@PathVariable Long tenantId) {
        return rentPaymentService.getPaymentsByTenantId(tenantId);
    }

    @PostMapping
    public RentPayment createPayment(@RequestBody RentPayment payment) {
        return rentPaymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public RentPayment updatePayment(@PathVariable Long id, @RequestBody RentPayment paymentDetails) {
        return rentPaymentService.updatePayment(id, paymentDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        rentPaymentService.deletePayment(id);
    }

    @GetMapping("/status/{status}")
    public List<RentPayment> getPaymentsByStatus(@PathVariable String status) {
        return rentPaymentService.getPaymentsByStatus(status);
    }
}
