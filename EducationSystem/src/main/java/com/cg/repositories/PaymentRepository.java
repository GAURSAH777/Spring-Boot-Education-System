package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
