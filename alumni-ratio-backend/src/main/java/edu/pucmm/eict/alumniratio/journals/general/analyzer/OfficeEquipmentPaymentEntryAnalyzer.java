package edu.pucmm.eict.alumniratio.journals.general.analyzer;

import edu.pucmm.eict.alumniratio.accounts.AccountBook;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournalRow;
import edu.pucmm.eict.alumniratio.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfficeEquipmentPaymentEntryAnalyzer implements GeneralJournalEntryAnalyzer {
    @Override
    public GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise) {
        var entryExplanation = String.format("Pago de equipos de oficina tomado a crédito del día %s", transaction.getPaymentReference());
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var cashAccountName = "Efectivo";
        var accountsPayableAccountName = "Cuentas por pagar";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.ACCOUNTS_PAYABLES, accountsPayableAccountName, transaction.getDebit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getCredit()));
        return entry;
    }
}
