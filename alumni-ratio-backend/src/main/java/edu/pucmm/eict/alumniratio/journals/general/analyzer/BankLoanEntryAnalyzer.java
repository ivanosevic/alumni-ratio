package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.accounts.AccountBook;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalRow;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankLoanEntryAnalyzer implements GeneralJournalEntryAnalyzer {
    @Override
    public GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Prestamo bancario";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var notesPayableAccountName = "Documentos por pagar";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, transaction.getAmount(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.NOTES_PAYABLES, notesPayableAccountName, BigDecimal.ZERO, transaction.getAmount()));
        return entry;
    }
}
