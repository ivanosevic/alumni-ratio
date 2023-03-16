package edu.pucmm.eict.journals.general.analyzer;

import edu.pucmm.eict.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.transactions.Transaction;

public interface GeneralJournalEntryAnalyzer {

    GeneralJournalEntry analyzeTransaction(Transaction transaction);
}
