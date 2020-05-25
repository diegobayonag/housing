package com.scotiabank.housing.rest.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.housing.rest.models.MortgageInformation;
import com.scotiabank.housing.rest.services.IMortgageCalculator;
import com.scotiabank.housing.rest.util.ErrorMessageWrapper;


/**
* <h1>Monthly mortgage payment rest controller</h1>
* Provides the service for the monthly mortgage payments
*
* @author  Diego Bayona Gómez
* @version 1.0
* @since   2020-05-23
*/

@RestController
@RequestMapping(value="/v1/mortgageMontlyPayment")
public class MortgageMonthlyPaymentController implements IMortgageMonthlyPaymentController {
	
	@Autowired
	private IMortgageCalculator _mortgageCalculatorService;
	
	private Logger logger = LoggerFactory.getLogger(MortgageMonthlyPaymentController.class); 
	
	/**
     * POST /calculate : Calculates the monthly mortgage payment based on the mortgage information
     * 
     * @param body Mortgage Information object (required)
     * @return successful operation (status code 200) with the Mortgage Information including the estimated monthly payment on the Response Entity
     * 
     */
	
	@RequestMapping(value = "/calculate", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping	
	public ResponseEntity<?> calculateMonthlyMortgagePayment(@Valid @RequestBody MortgageInformation loanInformation){
				
		logger.info("Calculating monthly mortgage payment.");
		
		_mortgageCalculatorService.calculateTotalMontlyPayment(loanInformation);
		
		logger.info("Estimated monthly mortgage payment: "+loanInformation.getTotalMontlyMortgagePayment());
		
		return new ResponseEntity<MortgageInformation>(loanInformation, HttpStatus.OK); 
	}
	
	
	/**
     * General constrains custom handler
     * 
     * @param MethodArgumentNotValidException exception related to Bean validation
     * @return List of errors wrapped on ErrorMessageWrapper 
     * 
     */
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorMessageWrapper> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    
		BindingResult br = ex.getBindingResult(); 
		
		List<ErrorMessageWrapper> errors = new Vector<ErrorMessageWrapper>();
		
		br.getFieldErrors().forEach(error -> 
        	errors.add(new ErrorMessageWrapper(new Vector<String>(Arrays.asList(error.getCodes())).firstElement().toString(), error.getField(), error.getDefaultMessage())));
		
		br.getGlobalErrors().forEach(error -> 
			errors.add(new ErrorMessageWrapper(new Vector<String>(Arrays.asList(error.getCodes())).firstElement().toString(), error.getObjectName(), error.getDefaultMessage())));
	
		errors.forEach(error ->
				logger.error(error.getErrorField()+":"+error.getErrorMessage()));
		
		return errors;
	}
	
	
}
