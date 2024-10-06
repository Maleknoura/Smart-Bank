package com.wora.smartbank.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "First name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;
    @NotBlank(message = "CIN is required")
    private String cin;
    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;
    @NotNull(message = "Start employment date is required")
    private LocalDate startEmployementDate;

    @NotNull(message = "Monthly income is required")
    @Positive(message = "Monthly income must be positive")
    private Double monthlyIncome;
    private boolean hasActivateCredits;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    private String type;
    private String position;
    private String title;
    @NotBlank(message = "Amount is required")
    private String amount;

    @Min(value = 1, message = "Duration in months must be at least 1")
    private int durationsInMonths;

    @NotNull(message = "Monthly payment is required")
    @Positive(message = "Monthly payment must be positive")
    private BigDecimal monthlyPayment;
    public Request() {}
    public Request(long id, String firstName, String lastName, String cin, LocalDate birthDate,
                   LocalDate startEmployementDate, Double monthlyIncome, boolean hasActivateCredits,
                   String email, String phoneNumber, String type, String position,
                   String amount, int durationsInMonths, BigDecimal monthlyPayment,String title) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.birthDate = birthDate;
        this.startEmployementDate = startEmployementDate;
        this.monthlyIncome = monthlyIncome;
        this.hasActivateCredits = hasActivateCredits;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.position = position;
        this.amount = amount;
        this.durationsInMonths = durationsInMonths;
        this.monthlyPayment = monthlyPayment;
        this.title=title;
    }
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCIN() {
        return cin;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getStartEmployementDate() {
        return startEmployementDate;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public boolean isHasActivateCredits() {
        return hasActivateCredits;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getType() {
        return type;
    }

    public String getPosition() {
        return position;
    }

    public String getAmount() {
        return amount;
    }

    public int getDurationsInMonths() {
        return durationsInMonths;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCin(@NotBlank(message = "CIN is required") String cin) {
        this.cin = cin;
    }

    public @NotBlank(message = "CIN is required") String getCin() {
        return cin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCIN(String cin) {
        this.cin = cin;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setStartEmployementDate(LocalDate startEmployementDate) {
        this.startEmployementDate = startEmployementDate;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setHasActivateCredits(boolean hasActivateCredits) {
        this.hasActivateCredits = hasActivateCredits;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDurationsInMonths(int durationsInMonths) {
        this.durationsInMonths = durationsInMonths;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
