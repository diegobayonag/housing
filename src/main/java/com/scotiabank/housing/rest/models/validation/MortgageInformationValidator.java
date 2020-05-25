package com.scotiabank.housing.rest.models.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.scotiabank.housing.rest.models.MortgageInformation;

/**
* <h1>Mortgage Information Validator</h1>
* Custom validator for the Mortgage Information Bean  
*
* @author  Diego Bayona Gómez
* @version 1.0
* @since   2020-05-23
*/

public class MortgageInformationValidator implements ConstraintValidator<ValidMortgageInformation,MortgageInformation>{

	
	/**
	 * Validates the rule: down payment cannot be higher than 10% of the property purchase price
	 * @param MortgageInformation
	 * @return Assert if down payment is higher than 10% of the property purchase price
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
