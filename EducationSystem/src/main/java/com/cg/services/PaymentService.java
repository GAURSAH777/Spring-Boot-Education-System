package com.cg.services;

import java.util.List;

import com.cg.entities.Payment;

public interface PaymentService {

	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

	public Payment getPaymentById(int paymentId);
}
