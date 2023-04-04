package edu.pucmm.eict.transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private Integer paymentType;
    private LocalDate date;
    private BigDecimal amount;
    private BigDecimal credit;
    private BigDecimal debit;
    private Integer type;
    private Integer paymentReference;

    public Transaction() {
    }

    public Transaction(Integer id, Integer paymentType, LocalDate date, BigDecimal amount, BigDecimal credit, BigDecimal debit, Integer type, Integer paymentReference) {
        this.id = id;
        this.paymentType = paymentType;
        this.date = date;
        this.amount = amount;
        this.credit = credit;
        this.debit = debit;
        this.type = type;
        this.paymentReference = paymentReference;
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
        return date.getDayOfMonth();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer transactionType) {
        this.type = transactionType;
    }

    public Integer getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(Integer transactionReference) {
        this.paymentReference = transactionReference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", paymentType=" + paymentType +
                ", date=" + date +
                ", amount=" + amount +
                ", credit=" + credit +
                ", debit=" + debit +
                ", transactionType=" + type +
                ", transactionReference=" + paymentReference +
                '}';
    }
}
