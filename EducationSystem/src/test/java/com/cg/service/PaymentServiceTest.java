package com.cg.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entities.Payment;
import com.cg.repositories.PaymentRepository;
import com.cg.services.PaymentServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)

@SpringBootTest
public class PaymentServiceTest {
	@InjectMocks
	private PaymentServiceImpl payService;

	@MockBean
	private PaymentRepository payRepo;

	@Test
	public void testAddPayment() {
		Payment pay = new Payment();
		pay.setCardNumber(2345);
		pay.setCardType("debit");
		pay.setBankName("HDFC");
		pay.setAmount(30000);
		pay.setDescription("good");
		pay.setPaymentDate(LocalDate.parse("2020-07-29"));
		Mockito.when(payRepo.save(pay)).thenReturn(pay);
		assertThat(payService.savePayment(pay)).isEqualTo(pay);
	}

	@Test
	public void testViewPayment() {
		Payment pay1 = new Payment();
		pay1.setCardNumber(1678);
		pay1.setCardType("debit");
		pay1.setBankName("axis");
		pay1.setAmount(20000);
		pay1.setDescription("complete");
		pay1.setPaymentDate(LocalDate.parse("1999-07-29"));

		Payment pay2 = new Payment();
		pay2.setCardNumber(1278);
		pay2.setCardType("debit");
		pay2.setBankName("saraswat");
		pay2.setAmount(21000);
		pay2.setDescription("complete");
		pay2.setPaymentDate(LocalDate.parse("1999-07-29"));

		List<Payment> payList = new ArrayList<>();
		payList.add(pay1);
		payList.add(pay2);

		Mockito.when(payRepo.findAll()).thenReturn(payList);
		assertThat(payService.getAllPayments()).isEqualTo(payList);
	}

}
