package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.accounts.AccountBook;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalRow;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WagesExpensesEntryAnalyzer implements GeneralJournalEntryAnalyzer {
    @Override
    public GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Pago de sueldo.";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var accountsPayableAccountName = "Gasto sueldos";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.WAGES_EXPENSES, accountsPayableAccountName, transaction.getAmount(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getAmount()));
        return entry;
    }
}
