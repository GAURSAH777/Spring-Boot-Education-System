package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Payment;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAllPayments() {

		List<Payment> payments = paymentRepository.findAll();

		return payments;
	}

	@Override
	public Payment savePayment(Payment payment) {

		Payment savedPayment = paymentRepository.save(payment);

		return savedPayment;
	}

	@Override
	public Payment getPaymentById(int paymentId) {

		Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);

		if (optionalPayment == null) {
			throw new ResourceNotFoundException("Product not exising with id: " + paymentId);
		}

		Payment payment = optionalPayment.get();

		return payment;
	}

}