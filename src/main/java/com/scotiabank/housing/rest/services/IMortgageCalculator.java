package com.scotiabank.housing.rest.services;

import com.scotiabank.housing.rest.models.MortgageInformation;

public interface IMortgageCalculator {

	void calculateTotalMontlyPayment(MortgageInformation loanInformation);

}