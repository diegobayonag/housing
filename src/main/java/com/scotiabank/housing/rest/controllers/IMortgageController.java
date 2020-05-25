package com.scotiabank.housing.rest.controllers;

import org.springframework.http.ResponseEntity;

import com.scotiabank.housing.rest.models.MortgageInformation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Mortgage", protocols = "http, https", produces = "application/json", consumes = "application/json")

public interface IMortgageController {

	@ApiOperation(value  = "Calculate monthly mortgage payment"
				  ,notes = "This operation* provides the calculation for "
						   + "........")

	@ApiResponses(value = { @ApiResponse(code = 202, message = "montly mortgage paymente sucessfully calculated*"),
							@ApiResponse(code = 400, message = "Invalid request*"), })

	public abstract ResponseEntity<?> calculateMontlyMortgagePayment(
			@ApiParam(value = "Mortgage Information", required = true) MortgageInformation loanInformation);

	
	
}