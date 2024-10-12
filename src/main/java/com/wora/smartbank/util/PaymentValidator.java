package com.wora.smartbank.util;

import com.wora.smartbank.dto.RequestDetails;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentValidator {

    private static final double TAX_RATE = 12.0;
    private static final double MONTHLY_RATE = TAX_RATE / 12.0 / 100.0;

    public RequestDetails calculate(RequestDetails requestDetails) {
        double calculatedMonthlyPayment = (requestDetails.amount() * MONTHLY_RATE) /
                (1 - Math.pow(1 + MONTHLY_RATE, -requestDetails.durationInmonths()));

        return new RequestDetails(requestDetails.type(), requestDetails.amount(), requestDetails.durationInmonths(), calculatedMonthlyPayment);
    }

    public boolean validateRequestDetails(RequestDetails requestDetails) {
        RequestDetails calculatedDetails = calculate(requestDetails);
        return requestDetails.monthlyIncome().equals(calculatedDetails.monthlyIncome());
    }
}
