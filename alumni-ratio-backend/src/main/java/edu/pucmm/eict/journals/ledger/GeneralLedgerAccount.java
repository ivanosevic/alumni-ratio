package edu.pucmm.eict.journals.ledger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class GeneralLedgerAccount implements Serializable {

    private Integer account;
    private boolean contraAccount;
    private BigDecimal finalBalance;
    private List<GeneralLedgerEntry> entries;

    public GeneralLedgerAccount() {
        this.contraAccount = false;
    }

    public GeneralLedgerAccount(Integer account, boolean contraAccount, List<GeneralLedgerEntry> entries) {
        this.account = account;
        this.contraAccount = contraAccount;
        this.entries = entries;
    }

    public GeneralLedgerAccount(Integer account, boolean contraAccount, BigDecimal finalBalance, List<GeneralLedgerEntry> entries) {
        this.account = account;
        this.contraAccount = contraAccount;
        this.finalBalance = finalBalance;
        this.entries = entries;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public List<GeneralLedgerEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<GeneralLedgerEntry> entries) {
        this.entries = entries;
    }

    public boolean isContraAccount() {
        return contraAccount;
    }

    public void setContraAccount(boolean contraAccount) {
        this.contraAccount = contraAccount;
    }

    public BigDecimal getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(BigDecimal finalBalance) {
        this.finalBalance = finalBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralLedgerAccount that = (GeneralLedgerAccount) o;
        return contraAccount == that.contraAccount && Objects.equals(account, that.account) && Objects.equals(finalBalance, that.finalBalance) && Objects.equals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, contraAccount, finalBalance, entries);
    }
}
