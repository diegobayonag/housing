package com.scotiabank.housing.rest.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.scotiabank.housing.rest.models.MortgageInformation;
import com.scotiabank.housing.rest.util.ErrorMessageWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Mortgage monthly payment ", protocols = "http, https", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

public interface IMortgageMonthlyPaymentController {

	@ApiOperation(value  = "Calculate the monthly mortgage payment."
				  ,notes = "This operation provides the calculation of the monthly mortgage payment based on "
				  		+ "the financial information of the loan. The operation calculates the principal and "
				  		+ "interest without having in count homeowners insurance, property taxes and HOA fees."
				  ,response = MortgageInformation.class
			      )
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MortgageInformation.class),
							@ApiResponse(code = 400, message = "Bad Request", response = ErrorMessageWrapper.class), })

	public abstract ResponseEntity<?> calculateMonthlyMortgagePayment(
			@ApiParam(value = "Mortgage Information", required = true) MortgageInformation loanInformation);

	
	
}