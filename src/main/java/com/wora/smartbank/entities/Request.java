package com.wora.smartbank.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

public class Request implements Serializable {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String CIN;
    private LocalDate BirthDate;
    private LocalDate StartEmployementDate;
    private Double MonthlyIncome;
    private boolean hasActivateCredits;
    private String Email;
    private String PhoneNumber;
    private String Type;
    private String position;
    private String amount;
    private int durationsInMonths;
    private BigDecimal monthlyPayment;

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
        return CIN;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public LocalDate getStartEmployementDate() {
        return StartEmployementDate;
    }

    public Double getMonthlyIncome() {
        return MonthlyIncome;
    }

    public boolean isHasActivateCredits() {
        return hasActivateCredits;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getType() {
        return Type;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Request(){}

    public Request(long id, String firstName, String lastName, String CIN, LocalDate birthDate, LocalDate startEmployementDate, Double monthlyIncome, boolean hasActivateCredits, String email, String phoneNumber, String type, String position, String amount, int durationsInMonths, BigDecimal monthlyPayment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CIN = CIN;
        BirthDate = birthDate;
        StartEmployementDate = startEmployementDate;
        MonthlyIncome = monthlyIncome;
        this.hasActivateCredits = hasActivateCredits;
        Email = email;
        PhoneNumber = phoneNumber;
        Type = type;
        this.position = position;
        this.amount = amount;
        this.durationsInMonths = durationsInMonths;
        this.monthlyPayment = monthlyPayment;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public void setStartEmployementDate(LocalDate startEmployementDate) {
        StartEmployementDate = startEmployementDate;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        MonthlyIncome = monthlyIncome;
    }

    public void setHasActivateCredits(boolean hasActivateCredits) {
        this.hasActivateCredits = hasActivateCredits;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setType(String type) {
        Type = type;
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
