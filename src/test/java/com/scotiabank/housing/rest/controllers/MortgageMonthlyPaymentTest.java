package com.scotiabank.housing.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scotiabank.housing.rest.models.MortgageInformation;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MortgageMonthlyPaymentTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void givenCorrectMortgageInformation_thenStatus200() throws Exception {

		MortgageInformation info = new MortgageInformation();
		info.setAnualInterestRateAsPercentage(3.6);
		info.setDownPaymentOnTheMortgageLoan(33000);
		info.setPropertyPurchasePrice(660000);
		info.setLengthOfLoanInYears(30);

		String route = "/v1/mortgageMontlyPayment/calculate";
		
		
		mockMvc.perform(post(route)
	            .contentType("application/json")
	            .param("sendWelcomeMail", "true")
	            .content(objectMapper.writeValueAsString(info)))
	            .andExpect(status().isOk())
	            .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
		}
}
