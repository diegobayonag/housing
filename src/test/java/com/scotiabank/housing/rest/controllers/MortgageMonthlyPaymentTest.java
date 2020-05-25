package com.scotiabank.housing.rest.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.scotiabank.housing.rest.models.MortgageInformation;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MortgageMonthlyPaymentTest {

	private MockMvc mvcMock;
	
	@Test
	public void givenCorrectMortgageInformation_thenStatus200()
	  throws Exception {
	 
	    MortgageInformation info = new MortgageInformation();
	    info.setAnualInterestRateAsPercentage(3.6);
	    info.setDownPaymentOnTheMortgageLoan(33000);
	    info.setPropertyPurchasePrice(660000);
	    info.setLengthOfLoanInYears(30);
	    
	 
	    mvcMock.perform(MockMvcRequestBuilders.post("/v1/mortgageMontlyPayment/calculate")
	      .contentType(MediaType.APPLICATION_JSON))
//	      .content("{\"downPaymentOnTheMortgageLoan\" : 10000,"
//	    		  	+"\"propertyPurchasePrice\" : 360000,"
//	    		  	+"\"anualInterestRateAsPercentage\" : 200,"
//	    		  	+"\"lengthOfLoanInYears\" : 15"
//	    		  	+"}")
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.content()
	    		  .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      //.andExpect(jsonPath("$[0].totalMontlyMortgagePayment", is("bob")))
	      
	      //
	      ;
	}
}
