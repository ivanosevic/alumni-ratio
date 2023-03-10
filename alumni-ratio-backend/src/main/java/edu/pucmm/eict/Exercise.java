package edu.pucmm.eict;

import java.util.ArrayList;
import java.util.List;

public class Exercise
{
    private String companyOwner;
    private String companyName;
    private Integer monthOperations;
    private Integer yearOperations;
    private List<Transaction> transactions;

    public Exercise() {
    }

    public Exercise(String companyOwner, String companyName, Integer monthOperations, Integer yearOperations)
    {
        this.companyOwner = companyOwner;
        this.companyName = companyName;
        this.monthOperations = monthOperations;
        this.yearOperations = yearOperations;
        this.transactions = new ArrayList<>();
    }

    public String getCompanyOwner()
    {
        return companyOwner;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public Integer getMonthOperations()
    {
        return monthOperations;
    }

    public Integer getYearOperations()
    {
        return yearOperations;
    }

    public List<Transaction> getTransactions()
    {
        return transactions;
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
