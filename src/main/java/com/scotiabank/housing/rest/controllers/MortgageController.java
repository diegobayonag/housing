package com.scotiabank.housing.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.housing.rest.models.MortgageLoanInformation;
import com.scotiabank.housing.rest.services.IMortgageCalculator;
import com.scotiabank.housing.rest.util.ErrorMessageWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/v1/mortgage") // TODO: change for Mortgage Payment
@Api(tags = "Mortgage")
public class MortgageController {
	
	@Autowired
	private IMortgageCalculator _mortgageCalculatorService;
	
	
	//POST
	//@RequestMapping(value="/calculateMontlyPayment", method= RequestMethod.POST, headers="Accept=application/json")
	@PostMapping
	@ApiOperation(value = "Calculate montly mortgage payment",
				  notes = "This operation* provides the calculation for "+
							"........")
	
	@ApiResponses(value = {
						@ApiResponse(code = 202, message = "montly mortgage paymente sucessfully calculated*"),
						@ApiResponse(code = 400, message = "Invalid request*"),
				 })
	
	public ResponseEntity<?> calculateMontlyMortgagePayment(@RequestBody MortgageLoanInformation loanInformation){
		
		if(loanInformation.getPropertyPurchasePrice() <= 0
			|| loanInformation.getAnualInterestRateAsPercentage() <= 0
			|| loanInformation.getAnualInterestRateAsPercentage() >= 100)
			return new ResponseEntity<Object>(
					new ErrorMessageWrapper("the mortage information must have values greatter tahan 0")
											,HttpStatus.CONFLICT);
		
		_mortgageCalculatorService.calculateTotalMontlyPayment(loanInformation);
		
		return new ResponseEntity<MortgageLoanInformation>(loanInformation, HttpStatus.OK); 
	}
	
}
