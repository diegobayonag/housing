package com.scotiabank.housing.rest.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.housing.rest.models.MortgageInformation;
import com.scotiabank.housing.rest.services.IMortgageCalculator;
import com.scotiabank.housing.rest.util.ErrorMessageWrapper;

@RestController
@RequestMapping(value="/v1/mortgage") // TODO: change for Mortgage Payment

public class MortgageController implements IMortgageController {
	
	@Autowired
	private IMortgageCalculator _mortgageCalculatorService;
	
	
	
	/**
     * POST /mortgage : Process the monthly mortgage payment
     * 
     * @param body Mortgage Information object (required)
     * @return successful operation (status code 200) with the Mortgage Information Response Entity
     * 
     */
	
	@PostMapping
	public ResponseEntity<?> calculateMontlyMortgagePayment(@Valid @RequestBody MortgageInformation loanInformation){
				
		_mortgageCalculatorService.calculateTotalMontlyPayment(loanInformation);
		
		return new ResponseEntity<MortgageInformation>(loanInformation, HttpStatus.OK); 
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorMessageWrapper> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    
		BindingResult br = ex.getBindingResult(); 
		
		List<ErrorMessageWrapper> errors = new Vector<ErrorMessageWrapper>();
		
		br.getFieldErrors().forEach(error -> 
        	errors.add(new ErrorMessageWrapper(new Vector<String>(Arrays.asList(error.getCodes())).firstElement().toString(), error.getField(), error.getDefaultMessage())));
		
		br.getGlobalErrors().forEach(error -> 
			errors.add(new ErrorMessageWrapper(new Vector<String>(Arrays.asList(error.getCodes())).firstElement().toString(), error.getObjectName(), error.getDefaultMessage())));
	
		return errors;
	}
	
	
}
