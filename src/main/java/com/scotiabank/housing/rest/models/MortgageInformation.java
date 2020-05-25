package com.scotiabank.housing.rest.models;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.scotiabank.housing.rest.models.validation.ValidMortgageInformation;


@ValidMortgageInformation()
public class MortgageInformation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Positive
	private double downPaymentOnTheMortgageLoan;
	
	@Positive
	private double propertyPurchasePrice;
	
	@Min(0)
	@Max(100)
	private double anualInterestRateAsPercentage;
	
	@Min(1)
	@Max(ValidMortgageInformation.MAX_LENGTH_OF_LOAN_IN_YEARS)
	private double lengthOfLoanInYears;
	
	@PositiveOrZero
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

	public double getLengthOfLoanInYears() {
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

	public void setLengthOfLoanInYears(double lengthOfLoanInYears) {
		this.lengthOfLoanInYears = lengthOfLoanInYears;
	}

	public void setTotalMontlyMortgagePayment(double totalMontlyMortgagePAyment) {
		this.totalMontlyMortgagePayment = totalMontlyMortgagePAyment;
	}
}
