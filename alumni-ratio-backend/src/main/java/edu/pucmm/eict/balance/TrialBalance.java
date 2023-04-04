package edu.pucmm.eict.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.journals.ledger.GeneralLedger;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TrialBalance {

    private String id;
    private List<TrialBalanceEntry> entries;

    public TrialBalance() {
        this.id = new ObjectId().toString();
        this.entries = new ArrayList<>();
    }

    @JsonProperty("totalDebit")

    public BigDecimal getAmountDebit() {
        BigDecimal total = BigDecimal.ZERO;
        for (TrialBalanceEntry entry : entries) {
            total = total.add(entry.getDebit());
        }
        return total;
    }

    @JsonProperty("totalCredit")
    public BigDecimal getAmountCredit() {
        BigDecimal total = BigDecimal.ZERO;
        for (TrialBalanceEntry entry : entries) {
            total = total.add(entry.getCredit());
        }
        return total;
    }

    public void fillFromGeneralLedger(GeneralLedger generalLedger) {
        var entries = new ArrayList<TrialBalanceEntry>();
        generalLedger.getEntriesPerAccount().forEach(generalLedgerAccount -> {
            if (!generalLedgerAccount.getEntries().isEmpty()) {
                TrialBalanceEntry trialBalance;
                if (generalLedgerAccount.isContraAccount()) {
                    trialBalance = new TrialBalanceEntry(AccountBook.getAccountName(generalLedgerAccount.getAccount()), BigDecimal.ZERO, generalLedgerAccount.getFinalBalance());
                } else {
                    trialBalance = new TrialBalanceEntry(AccountBook.getAccountName(generalLedgerAccount.getAccount()), generalLedgerAccount.getFinalBalance(), BigDecimal.ZERO);
                }
                entries.add(trialBalance);
            }
        });
        this.entries.addAll(entries);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TrialBalanceEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TrialBalanceEntry> entries) {
        this.entries = entries;
    }
}
