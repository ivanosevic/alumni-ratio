package edu.pucmm.eict.journals.general.analyzer;

import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.journals.general.GeneralJournalRow;
import edu.pucmm.eict.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ServiceRevenuesEntryAnalyzer implements PaymentTypeEntryAnalyzer {

    @Override
    public GeneralJournalEntry debit(Transaction transaction, Exercise exercise) {
        var entryExplanation = String.format("Ofrecimiento de servicios por %s, al contado.", exercise.getCompanyName());
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var revenueAccountName = "Ingresos por servicios.";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, transaction.getDebit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.SERVICES_REVENUES, revenueAccountName, BigDecimal.ZERO, transaction.getDebit()));
        return entry;
    }

    @Override
    public GeneralJournalEntry credit(Transaction transaction, Exercise exercise) {
        var entryExplanation = String.format("Ofrecimiento de servicios por %s, a y crédito.", exercise.getCompanyName());
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var customersAccountName = "Clientes";
        var revenueAccountName = "Ingresos por servicios.";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CUSTOMERS, customersAccountName, transaction.getCredit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.SERVICES_REVENUES, revenueAccountName, BigDecimal.ZERO, transaction.getCredit()));
        return entry;
    }

    @Override
    public GeneralJournalEntry mixed(Transaction transaction, Exercise exercise) {
        var entryExplanation = String.format("Ofrecimiento de servicios por %s, al contado y crédito.", exercise.getCompanyName());
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var customersAccountName = "Clientes";
        var revenueAccountName = "Ingresos por servicios.";
        var amount = transaction.getCredit().add(transaction.getDebit());
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, transaction.getDebit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CUSTOMERS, customersAccountName, transaction.getCredit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.SERVICES_REVENUES, revenueAccountName, BigDecimal.ZERO, amount));
        return entry;
    }
}
