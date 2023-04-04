package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

public interface GeneralJournalEntryAnalyzer {

    GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise);
}
