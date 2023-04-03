package edu.pucmm.eict.journals.general.analyzer;

import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.journals.general.GeneralJournalRow;
import edu.pucmm.eict.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankLoanPaymentEntryAnalyzer implements GeneralJournalEntryAnalyzer {
    @Override
    public GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise) {
        var entryExplanation = String.format("Pago de prestamo bancario del día %s", transaction.getPaymentReference());
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var notesPayableAccountName = "Documentos por pagar";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.NOTES_PAYABLES, notesPayableAccountName, transaction.getAmount(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getAmount()));
        return entry;
    }
}
