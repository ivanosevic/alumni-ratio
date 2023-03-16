package edu.pucmm.eict.journals.general;

import edu.pucmm.eict.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralJournal {
    private final List<GeneralJournalEntry> generalJournalEntries;

    public GeneralJournal() {
        this.generalJournalEntries = new ArrayList<>();
    }

    public void addTransactionAsEntry(Transaction transaction) {

    }

    public List<GeneralJournalEntry> getGeneralJournalEntries() {
        return generalJournalEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralJournal that = (GeneralJournal) o;
        return Objects.equals(generalJournalEntries, that.generalJournalEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generalJournalEntries);
    }

    @Override
    public String toString() {
        return "GeneralJournal{" +
                "generalJournalEntries=" + generalJournalEntries +
                '}';
    }
}
