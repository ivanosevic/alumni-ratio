package edu.pucmm.eict.alumniratio.journals.ledger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.pucmm.eict.alumniratio.accounts.AccountBook;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralLedger {

    @JsonIgnore
    private Exercise exercise;

    private List<GeneralLedgerAccount> entriesPerAccount;

    public GeneralLedger() {
    }

    public GeneralLedger(Exercise exercise) {
        this.exercise = exercise;
        this.entriesPerAccount = new ArrayList<>();
    }

    public void carryOverFromGeneralJournal(GeneralJournal generalJournal) {
        AccountBook.ALL_ACCOUNTS.forEach(accountNumber -> {
            var generalJournalRowsByAccount = generalJournal.getRowsByAccountReference(accountNumber);
            var generalLedgerEntries = new ArrayList<GeneralLedgerEntry>();
            BigDecimal balance = BigDecimal.ZERO;
            for (var row : generalJournalRowsByAccount) {
                BigDecimal credit = row.getCredit();
                BigDecimal debit = row.getDebit();
                if (AccountBook.isContraAccount(accountNumber)) {
                    balance = balance.add(credit.subtract(debit));
                } else {
                    balance = balance.add(debit.subtract(credit));
                }
                var newEntry = new GeneralLedgerEntry(row.getDate(), row.getReference(), row.getDebit(), row.getCredit(), balance);
                generalLedgerEntries.add(newEntry);
            }
            entriesPerAccount.add(new GeneralLedgerAccount(accountNumber, AccountBook.isContraAccount(accountNumber), balance, generalLedgerEntries));
        });
    }

    public Exercise getExercise() {
        return exercise;
    }

    public List<GeneralLedgerAccount> getEntriesPerAccount() {
        return entriesPerAccount;
    }

    public List<GeneralLedgerEntry> getEntriesPerAccount(Integer account) {
        var results = entriesPerAccount.stream().filter(generalLedgerAccount -> generalLedgerAccount.getAccount().equals(account)).toList();
        return results.stream().flatMap(generalLedgerAccount -> generalLedgerAccount.getEntries().stream()).toList();
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setEntriesPerAccount(List<GeneralLedgerAccount> entriesPerAccount) {
        this.entriesPerAccount = entriesPerAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralLedger that = (GeneralLedger) o;
        return Objects.equals(exercise, that.exercise) && Objects.equals(entriesPerAccount, that.entriesPerAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exercise, entriesPerAccount);
    }
}
