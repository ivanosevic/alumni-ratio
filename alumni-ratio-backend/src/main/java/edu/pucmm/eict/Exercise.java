package edu.pucmm.eict;

import java.util.List;

public class Exercise
{
    private String companyOwner;
    private String companyName;
    private Integer monthOperations;
    private Integer yearOperations;
    private List transactions;

    public Exercise(String companyOwner, String companyName, Integer monthOperations, Integer yearOperations, Transaction[] transactions)
    {
        this.companyOwner = companyOwner;
        this.companyName = companyName;
        this.monthOperations = monthOperations;
        this.yearOperations = yearOperations;
        this.transactions = List.of(transactions);
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

    public List getTransactions()
    {
        return transactions;
    }
}
