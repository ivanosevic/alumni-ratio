package edu.pucmm.eict.exercises;

import edu.pucmm.eict.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise {
    private String companyOwner;
    private String companyName;
    private Integer monthOperations;
    private Integer yearOperations;
    private boolean requiresAssistance;
    private List<Transaction> transactions;

    public Exercise() {
    }

    public Exercise(String companyOwner, String companyName, Integer monthOperations, Integer yearOperations) {
        this.companyOwner = companyOwner;
        this.companyName = companyName;
        this.monthOperations = monthOperations;
        this.yearOperations = yearOperations;
        this.transactions = new ArrayList<>();
    }

    public String getCompanyOwner() {
        return companyOwner;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getMonthOperations() {
        return monthOperations;
    }

    public Integer getYearOperations() {
        return yearOperations;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setMonthOperations(Integer monthOperations) {
        this.monthOperations = monthOperations;
    }

    public void setYearOperations(Integer yearOperations) {
        this.yearOperations = yearOperations;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isRequiresAssistance() {
        return requiresAssistance;
    }

    public void setRequiresAssistance(boolean requiresAssistance) {
        this.requiresAssistance = requiresAssistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(companyOwner, exercise.companyOwner) && Objects.equals(companyName, exercise.companyName) && Objects.equals(monthOperations, exercise.monthOperations) && Objects.equals(yearOperations, exercise.yearOperations) && Objects.equals(transactions, exercise.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyOwner, companyName, monthOperations, yearOperations, transactions);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "companyOwner='" + companyOwner + '\'' +
                ", companyName='" + companyName + '\'' +
                ", monthOperations=" + monthOperations +
                ", yearOperations=" + yearOperations +
                ", transactions=" + transactions +
                '}';
    }
}
