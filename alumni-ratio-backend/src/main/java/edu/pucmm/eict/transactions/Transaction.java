package edu.pucmm.eict.transactions;

import java.math.BigDecimal;

public class Transaction {
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

    public Transaction(Integer id, Integer paymentType, Integer day, BigDecimal amount, BigDecimal credit, BigDecimal debit, Integer transactionType, Integer transactionReference) {
        this.id = id;
        this.paymentType = paymentType;
        this.day = day;
        this.amount = amount;
        this.credit = credit;
        this.debit = debit;
        this.transactionType = transactionType;
        this.transactionReference = transactionReference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(Integer transactionReference) {
        this.transactionReference = transactionReference;
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
