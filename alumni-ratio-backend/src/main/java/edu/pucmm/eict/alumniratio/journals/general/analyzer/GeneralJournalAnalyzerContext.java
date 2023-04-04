package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

public class GeneralJournalAnalyzerContext {

    private GeneralJournalEntryAnalyzer analyzer;

    public void setAnalyzer(GeneralJournalEntryAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public GeneralJournalEntry analyze(Transaction transaction, Exercise exercise) {
        return analyzer.analyzeTransaction(transaction, exercise);
    }
}
