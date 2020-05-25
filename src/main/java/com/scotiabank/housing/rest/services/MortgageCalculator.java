package com.scotiabank.housing.rest.services;

import org.springframework.stereotype.Service;

import com.scotiabank.housing.rest.models.MortgageInformation;


@Service("mortgageCalculator")
public class MortgageCalculator implements IMortgageCalculator {
	
	/**
	 * Equation for mortgage payments
	 *  
	 * M = P[ r ((1+r)^n) /( ((1+r)^n) - 1)] 
	 * 
	 * M = the total monthly mortgage payment. 
	 * P = the principal loan amount. 
	 * r = monthly interest rate. Lenders provide you an annual rate so you'll need to divide
	 * 	   that figure by 12 (the number of months in a year) to get the monthly rate. 
	 * n = number of payments over the loan's lifetime. Multiply
	 *     the number of years in your loan term by 12 (the number of months in a year)
	 *     to get the number of payments for the loan. 
	 * 		
 	 *     https://www.bankrate.com/calculators/mortgages/mortgage calculator.aspx
 	 *     
 	 * Example resource:
 	 * 
 	 *     https://www.youtube.com/watch?v=Pgot9V7uZXw
 	 *     
	 **/	
	
	@Override
	public void calculateTotalMontlyPayment(MortgageInformation loanInformation)
	{	
		
		double P = loanInformation.getPropertyPurchasePrice() - loanInformation.getDownPaymentOnTheMortgageLoan();
		
		double r = ((loanInformation.getAnualInterestRateAsPercentage())/100/12);
			
		double n = (loanInformation.getLengthOfLoanInYears()*12);
			
		double factor = Math.pow((1+r),n);
		
		double M = P*((r*factor)/(factor-1));
	
		loanInformation.setTotalMontlyMortgagePayment(M);
		
	}
	
}
