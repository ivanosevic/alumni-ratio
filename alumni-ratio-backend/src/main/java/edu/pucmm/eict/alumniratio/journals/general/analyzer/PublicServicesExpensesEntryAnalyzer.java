package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.accounts.AccountBook;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalRow;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PublicServicesExpensesEntryAnalyzer implements GeneralJournalEntryAnalyzer {
    @Override
    public GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Pago de servicios públicos.";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var accountsPayableAccountName = "Gasto servicios públicos";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.PUBLIC_SERVICES_EXPENSES, accountsPayableAccountName, transaction.getAmount(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getAmount()));
        return entry;
    }
}
