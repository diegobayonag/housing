package com.scotiabank.housing.rest.models.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Constraint(validatedBy = MortgageInformationValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMortgageInformation {
	
	public static final float MAX_PERCENTAGE_FOR_DOWNPAYMENT = 10;
	
	public static final int MAX_LENGTH_OF_LOAN_IN_YEARS = 30;
	
	String message() default "{com.scotiabank.housing.rest.models.validation.downpaymentLimit}";
	
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
	
}
