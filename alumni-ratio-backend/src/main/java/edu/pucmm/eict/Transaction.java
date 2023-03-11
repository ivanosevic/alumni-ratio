package edu.pucmm.eict;

import java.math.BigDecimal;

//Esta es la primera clase creada para nuestro proyecto
public class Transaction
{
    //A continuacion los atributos de la clase
    private Integer id;
    private Integer paymentType;
    private Integer day;
    private BigDecimal amount;
    private BigDecimal credit;
    private BigDecimal debit;
    private Integer transactionType;
    private Integer transactionReference;

    public Transaction() {
    }

    public Transaction(Integer id, Integer paymentType, Integer day, BigDecimal amount, BigDecimal credit, BigDecimal debit, Integer transactionType, Integer transactionReference)
    {
        this.id = id;
        this.paymentType = paymentType;
        this.day = day;
        this.amount = amount;
        this.credit = credit;
        this.debit = debit;
        this.transactionType = transactionType;
        this.transactionReference = transactionReference;
    }

    public Integer getId()
    {
        return id;
    }

    public Integer getPaymentType()
    {
        return paymentType;
    }

    public Integer getDay()
    {
        return day;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public BigDecimal getCredit()
    {
        return credit;
    }

    public BigDecimal getDebit()
    {
        return debit;
    }

    public Integer getTransactionType()
    {
        return transactionType;
    }

    public Integer getTransactionReference()
    {
        return transactionReference;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", paymentType=" + paymentType +
                ", day=" + day +
                ", amount=" + amount +
                ", credit=" + credit +
                ", debit=" + debit +
                ", transactionType=" + transactionType +
                ", transactionReference=" + transactionReference +
                '}';
    }
}
