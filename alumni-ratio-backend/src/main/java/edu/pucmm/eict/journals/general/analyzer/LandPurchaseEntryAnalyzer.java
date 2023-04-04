package edu.pucmm.eict.journals.general.analyzer;

import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.journals.general.GeneralJournalRow;
import edu.pucmm.eict.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LandPurchaseEntryAnalyzer implements PaymentTypeEntryAnalyzer {
    @Override
    public GeneralJournalEntry debit(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Compra de terreno al contado.";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var landAccountName = "Terrenos";
        var cashAccountName = "Efectivo";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.LANDS, landAccountName, transaction.getDebit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getDebit()));
        return entry;
    }

    @Override
    public GeneralJournalEntry credit(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Compra de terreno a crédito.";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var landAccountName = "Terrenos";
        var notesPayableAccountName = "Documentos por pagar";
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.LANDS, landAccountName, transaction.getCredit(), BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.NOTES_PAYABLES, notesPayableAccountName, BigDecimal.ZERO, transaction.getCredit()));
        return entry;
    }

    @Override
    public GeneralJournalEntry mixed(Transaction transaction, Exercise exercise) {
        var entryExplanation = "Compra de terreno al contado y crédito.";
        var transactionDate = LocalDate.of(exercise.getYearOperations(), exercise.getMonthOperations(), transaction.getDay());
        var entry = new GeneralJournalEntry(transactionDate, entryExplanation);
        var landAccountName = "Terrenos";
        var cashAccountName = "Efectivo";
        var notesPayableAccountName = "Documentos por pagar";
        var amount = transaction.getCredit().add(transaction.getDebit());
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.LANDS, landAccountName, amount, BigDecimal.ZERO));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.NOTES_PAYABLES, notesPayableAccountName, BigDecimal.ZERO, transaction.getCredit()));
        entry.addRow(new GeneralJournalRow(transactionDate, AccountBook.CASH, cashAccountName, BigDecimal.ZERO, transaction.getDebit()));
        return entry;
    }
}
