package edu.pucmm.eict.journals.general;

import edu.pucmm.eict.transactions.Transaction;

import java.util.List;

public class GeneralJournal {
    private final List<Transaction> list;
    private Transaction transaction;
    private List<Transaction> GeneralJournalEntry;

    public GeneralJournal(Transaction transaction, List<Transaction> list) {
        this.transaction = transaction;
        this.list = list;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public List<Transaction> getList() {
        return list;
    }
}
