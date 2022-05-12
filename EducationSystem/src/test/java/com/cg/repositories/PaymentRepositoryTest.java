package com.cg.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entities.Payment;
import com.cg.repositories.PaymentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PaymentRepositoryTest {
	@Autowired
	private PaymentRepository paymentRepo;

	public Payment getPayment() {
		Payment pay = new Payment();
		pay.setCardNumber(2345);
		pay.setCardType("debit");
		pay.setBankName("HDFC");
		pay.setAmount(30000);
		pay.setDescription("good");
		pay.setPaymentDate(LocalDate.parse("2020-07-29"));
		return pay;
	}

	@Test
	@Rollback(false)
	public void testAddPayment() {
		Payment payment = getPayment();
		Payment addPay = paymentRepo.save(payment);
		Payment getPay = paymentRepo.getOne(addPay.getTransactionId());
		assertNotNull(addPay);
		assertThat(addPay).isEqualTo(getPay);
	}

	@Test
	public void getAllPayment() {
		List<Payment> payList = paymentRepo.findAll();
		assertNotNull(payList);
		assertThat(payList).size().isGreaterThan(0);
	}

}
