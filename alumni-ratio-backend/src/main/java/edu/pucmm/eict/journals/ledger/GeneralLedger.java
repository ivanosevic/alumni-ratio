package edu.pucmm.eict.journals.ledger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.GeneralJournal;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.util.*;

public class GeneralLedger {

    @JsonIgnore
    @BsonIgnore
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
            var generalLedgerEntries = generalJournalRowsByAccount.stream().map(row -> new GeneralLedgerEntry(row.getDate(), row.getReference(), row.getDebit(), row.getCredit())).toList();
            entriesPerAccount.add(new GeneralLedgerAccount(accountNumber, generalLedgerEntries));
        });
    }

    public Exercise getExercise() {
        return exercise;
    }

    public List<GeneralLedgerAccount> getEntriesPerAccount() {
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
