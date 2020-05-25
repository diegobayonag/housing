package com.scotiabank.housing.rest.models;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.scotiabank.housing.rest.models.validation.ValidMortgageInformation;


/**
* <h1>Mortgage Information</h1>
* Bean that encapsulate the Mortgage Informationfor request and response 
*
* @author  Diego Bayona Gómez
* @version 1.0
* @since   2020-05-23
*/

@ValidMortgageInformation()
public class MortgageInformation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Positive(message = "{com.scotiabank.housing.rest.models.validation.numericalPositiveValues}")
	private double downPaymentOnTheMortgageLoan;
	
	@Positive(message = "{com.scotiabank.housing.rest.models.validation.numericalPositiveValues}")
	private double propertyPurchasePrice;
	
	@Min(value = 0, message = "{com.scotiabank.housing.rest.models.validation.numericalPositiveValues}")
	@Max(value = 100, message="{com.scotiabank.housing.rest.models.validation.maxPercentage}")
	private double anualInterestRateAsPercentage;
	
	@Min(value = 1, message = "{com.scotiabank.housing.rest.models.validation.numericalPositiveValues}")
	@Max(value = ValidMortgageInformation.MAX_LENGTH_OF_LOAN_IN_YEARS, message = "{com.scotiabank.housing.rest.models.validation.maxYearsOfLoan}" )
	private int lengthOfLoanInYears;
	
	@PositiveOrZero(message = "{com.scotiabank.housing.rest.models.validation.numericalPositiveValues}")
	private double totalMontlyMortgagePayment;

	
	// Getter Methods
	
	public double getDownPaymentOnTheMortgageLoan() {
		return downPaymentOnTheMortgageLoan;
	}

	public double getPropertyPurchasePrice() {
		return propertyPurchasePrice;
	}

	public double getAnualInterestRateAsPercentage() {
		return anualInterestRateAsPercentage;
	}

	public int getLengthOfLoanInYears() {
		return lengthOfLoanInYears;
	}

	public double getTotalMontlyMortgagePayment() {
		return totalMontlyMortgagePayment;
	}

	// Setter Methods

	public void setDownPaymentOnTheMortgageLoan(double downPaymentOnTheMortgageLoan) {
		this.downPaymentOnTheMortgageLoan = downPaymentOnTheMortgageLoan;
	}

	public void setPropertyPurchasePrice(double propertyPurchasePrice) {
		this.propertyPurchasePrice = propertyPurchasePrice;
	}

	public void setAnualInterestRateAsPercentage(double anualInterestRateAsPercentage) {
		this.anualInterestRateAsPercentage = anualInterestRateAsPercentage;
	}

	public void setLengthOfLoanInYears(int lengthOfLoanInYears) {
		this.lengthOfLoanInYears = lengthOfLoanInYears;
	}

	public void setTotalMontlyMortgagePayment(double totalMontlyMortgagePayment) {
		this.totalMontlyMortgagePayment = totalMontlyMortgagePayment;
	}
}
