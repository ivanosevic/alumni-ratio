package edu.pucmm.eict;

public class Exercise
{
    private String companyOwner;
    private String companyName;
    private Integer monthOperations;
    private Integer yearOperations;
    private Transaction transactions[];

    public Exercise(String companyOwner, String companyName, Integer monthOperations, Integer yearOperations, Transaction[] transactions)
    {
        this.companyOwner = companyOwner;
        this.companyName = companyName;
        this.monthOperations = monthOperations;
        this.yearOperations = yearOperations;
        this.transactions = transactions;
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

    public Transaction[] getTransactions()
    {
        return transactions;
    }
}
