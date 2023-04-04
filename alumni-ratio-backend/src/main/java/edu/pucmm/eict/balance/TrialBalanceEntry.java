package edu.pucmm.eict.balance;

import java.math.BigDecimal;
import java.util.Objects;

public class TrialBalanceEntry {

    private String accountName;
    private BigDecimal debit;
    private BigDecimal credit;

    public TrialBalanceEntry() {
    }

    public TrialBalanceEntry(String accountName, BigDecimal debit, BigDecimal credit) {
        this.accountName = accountName;
        this.debit = debit;
        this.credit = credit;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrialBalanceEntry that = (TrialBalanceEntry) o;
        return Objects.equals(accountName, that.accountName) && Objects.equals(debit, that.debit) && Objects.equals(credit, that.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, debit, credit);
    }
}
