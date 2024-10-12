package com.wora.smartbank.dto;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Embeddable
public record RequestDetails(
        @NotBlank String type,
        @NotNull @Positive Double amount,
        @NotNull @Positive int durationInmonths,
        @NotNull @Positive Double monthlyIncome
) {
    public RequestDetails(RequestDetails requestDetails, Double monthly) {
        this(requestDetails.type(), requestDetails.amount(), requestDetails.durationInmonths(), requestDetails.monthlyIncome());
    }
}
