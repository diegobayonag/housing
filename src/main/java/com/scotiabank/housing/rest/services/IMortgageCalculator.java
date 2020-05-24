package com.scotiabank.housing.rest.services;

import com.scotiabank.housing.rest.models.MortgageLoanInformation;

public interface IMortgageCalculator {

	void calculateTotalMontlyPayment(MortgageLoanInformation loanInformation);

}