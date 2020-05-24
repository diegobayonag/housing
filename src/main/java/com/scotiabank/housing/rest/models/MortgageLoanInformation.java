package com.scotiabank.housing.rest.models;

import java.io.Serializable;

public class MortgageLoanInformation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double downPaymentOnTheMortgageLoan;
	private double propertyPurchasePrice;
	private double anualInterestRateAsPercentage;
	private double lengthOfLoanInYears;
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
