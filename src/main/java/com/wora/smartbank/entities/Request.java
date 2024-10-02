package com.wora.smartbank.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String cin;
    private LocalDate birthDate;
    private LocalDate startEmployementDate;
    private Double monthlyIncome;
    private boolean hasActivateCredits;
    private String email;
    private String phoneNumber;
    private String type;
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


    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Request() {}

    public Request(long id, String firstName, String lastName, String cin, LocalDate birthDate,
                   LocalDate startEmployementDate, Double monthlyIncome, boolean hasActivateCredits,
                   String email, String phoneNumber, String type, String position,
                   String amount, int durationsInMonths, BigDecimal monthlyPayment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;  // Correction ici
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
