package edu.pucmm.eict.journals.ledger;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class GeneralLedgerAccount implements Serializable {

    private Integer account;
    private List<GeneralLedgerEntry> entries;

    public GeneralLedgerAccount() {
    }

    public GeneralLedgerAccount(Integer account, List<GeneralLedgerEntry> entries) {
        this.account = account;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralLedgerAccount that = (GeneralLedgerAccount) o;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }

    @Override
    public String toString() {
        return "GeneralLedgerAccount{" +
                "account=" + account +
                ", entries=" + entries +
                '}';
    }
}
