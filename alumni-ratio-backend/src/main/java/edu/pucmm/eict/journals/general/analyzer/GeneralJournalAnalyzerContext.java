package edu.pucmm.eict.journals.general.analyzer;

import edu.pucmm.eict.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.transactions.Transaction;

public class GeneralJournalAnalyzerContext {

    private GeneralJournalEntryAnalyzer analyzer;

    public void setAnalyzer(GeneralJournalEntryAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public GeneralJournalEntry analyze(Transaction transaction) {
        return analyzer.analyzeTransaction(transaction);
    }
}
