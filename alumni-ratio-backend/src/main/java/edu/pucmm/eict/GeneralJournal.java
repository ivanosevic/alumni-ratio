package edu.pucmm.eict;

import javax.swing.*;
import java.util.List;

//Este es el diario general en el que se registran las primeras transacciones
public class GeneralJournal
{
    private Transaction transaction;
    private List<Transaction> list;
    {
        GeneralJournalEntry generalJournalEntry;
        generalJournalEntry = new GeneralJournalEntry(transaction);
    }

    public GeneralJournal(Transaction transaction, List<Transaction> list)
    {
        this.transaction = transaction;
        this.list = list;
    }

    public Transaction getTransaction()
    {
        return transaction;
    }

    public List<Transaction> getList()
    {
        return list;
    }
}
