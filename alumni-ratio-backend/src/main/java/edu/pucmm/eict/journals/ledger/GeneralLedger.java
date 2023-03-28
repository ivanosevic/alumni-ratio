package edu.pucmm.eict.journals.ledger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.GeneralJournal;

import java.math.BigDecimal;
import java.util.*;

public class GeneralLedger {

    @JsonIgnore
    private final Exercise exercise;

    private final Map<Integer, List<GeneralLedgerEntry>> entriesPerAccount;

    public GeneralLedger(Exercise exercise) {
        this.exercise = exercise;
        this.entriesPerAccount = new HashMap<>();
    }

    public void carryOverFromGeneralJournal(GeneralJournal generalJournal) {
        AccountBook.ALL_ACCOUNTS.forEach(accountNumber -> {
            var generalJournalRowsByAccount = generalJournal.getRowsByAccountReference(accountNumber);
            var generalLedgerEntries = generalJournalRowsByAccount.stream().map(row -> new GeneralLedgerEntry(row.getDate(), row.getReference(), row.getDebit(), row.getCredit())).toList();
            entriesPerAccount.put(accountNumber, generalLedgerEntries);
        });
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Map<Integer, List<GeneralLedgerEntry>> getEntriesPerAccount() {
        return entriesPerAccount;
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
