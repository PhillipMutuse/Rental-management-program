package com.rentalmanagement.services;

import com.rentalmanagement.entities.RentPayment;

public interface PaymentGateway {
    boolean processPayment(RentPayment payment);
    String generatePaymentLink(RentPayment payment);
    boolean verifyPayment(String paymentId);
}
