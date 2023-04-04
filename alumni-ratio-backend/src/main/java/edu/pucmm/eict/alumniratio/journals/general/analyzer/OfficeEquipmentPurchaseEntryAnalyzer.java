package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.accounts.AccountBook;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalRow;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfficeEquipmentPurchaseEntryAnalyzer implements PaymentTypeEntryAnalyzer {

    @Override
    public GeneralJournalEntry debit(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Compra de equipos de oficina al contado";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var officeSuppliesAccountName = "Equipos de oficina";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.OFFICE_EQUIPMENT, officeSuppliesAccountName , transaction.getDebit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getDebit()));
        return entry;
    }

    @Override
    public GeneralJournalEntry credit(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Compra de equipos de oficina a crédito";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var accountPayablesName = "Cuentas por pagar";
        var officeSuppliesAccountName = "Equipos de oficina";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.OFFICE_EQUIPMENT, officeSuppliesAccountName , transaction.getCredit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.ACCOUNTS_PAYABLES, accountPayablesName, BigDecimal.ZERO, transaction.getCredit()));
        return entry;
    }

    @Override
    public GeneralJournalEntry mixed(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Compra de equipos de oficina al contado y crédito.";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var officeSuppliesAccountName = "Equipos de oficina";
        var accountPayablesName = "Cuentas por pagar";
        var amount = transaction.getCredit().add(transaction.getDebit());
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.OFFICE_EQUIPMENT, officeSuppliesAccountName , amount, BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.ACCOUNTS_PAYABLES, accountPayablesName, BigDecimal.ZERO, transaction.getCredit()));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getDebit()));
        return entry;
    }
}
