package com.scotiabank.housing.rest.models.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.scotiabank.housing.rest.models.MortgageInformation;

public class MortgageInformationValidator implements ConstraintValidator<ValidMortgageInformation,MortgageInformation>{

	
	/**
	 * Validate the rule
	 * down payment cannot be higher than 10% of the property purchase price
	 */
	
	@Override
	public boolean isValid(MortgageInformation value, ConstraintValidatorContext context) {
		if (!(value instanceof MortgageInformation))
			throw new IllegalArgumentException("@MortgageInformationValidator only applies to MortgageInformation");
    	
		MortgageInformation mortgageInformation = (MortgageInformation)value;
		
		double downPayment = mortgageInformation.getDownPaymentOnTheMortgageLoan();
		
		double propertyPurchacePrice = mortgageInformation.getPropertyPurchasePrice();
		
		return (downPayment <= ((propertyPurchacePrice/100)*10));
	}

	

}
