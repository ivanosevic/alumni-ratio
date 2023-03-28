package edu.pucmm.eict.journals.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.analyzer.*;
import edu.pucmm.eict.transactions.Transaction;
import edu.pucmm.eict.transactions.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GeneralJournal {

    @JsonIgnore
    private final Exercise exercise;
    private final List<GeneralJournalEntry> generalJournalEntries;

    public GeneralJournal(Exercise exercise) {
        this.exercise = exercise;
        this.generalJournalEntries = new ArrayList<>();
    }

    public void addTransactionAsEntry(Transaction transaction) {
        var analyzerContext = new GeneralJournalAnalyzerContext();
        if (transaction.getTransactionType().equals(TransactionType.OWNER_INVESTMENT)) {
            analyzerContext.setAnalyzer(new OwnerInvestmentEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.OFFICE_SUPPLIES_PURCHASE)) {
            analyzerContext.setAnalyzer(new OfficeSuppliesPurchaseEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.OFFICE_EQUIPMENT_PURCHASE)) {
            analyzerContext.setAnalyzer(new OfficeEquipmentPurchaseEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.LAND_PURCHASE)) {
            analyzerContext.setAnalyzer(new LandPurchaseEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.OFFICE_SUPPLIES_PAYMENT)) {
            analyzerContext.setAnalyzer(new OfficeSuppliesPaymentEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.OFFICE_EQUIPMENT_PAYMENT)) {
            analyzerContext.setAnalyzer(new OfficeEquipmentPaymentEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.BANK_LOAN)) {
            analyzerContext.setAnalyzer(new BankLoanEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.BANK_LOAN_PAYMENT)) {
            analyzerContext.setAnalyzer(new BankLoanPaymentEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.SERVICE_REVENUES)) {
            analyzerContext.setAnalyzer(new ServiceRevenuesEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.PUBLIC_SERVICES_EXPENSES)) {
            analyzerContext.setAnalyzer(new PublicServicesExpensesEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.RENT_EXPENSES)) {
            analyzerContext.setAnalyzer(new RentExpensesEntryAnalyzer());
        }

        if (transaction.getTransactionType().equals(TransactionType.WAGES_EXPENSES)) {
            analyzerContext.setAnalyzer(new WagesExpensesEntryAnalyzer());
        }
        var entry = analyzerContext.analyze(transaction, exercise);
        generalJournalEntries.add(entry);
    }

    public List<GeneralJournalRow> getRowsByAccountReference(Integer accountReference) {
        return generalJournalEntries.stream().flatMap(generalJournalEntry -> generalJournalEntry.getGeneralJournalRows().stream().filter(row -> row.getReference().equals(accountReference))).toList();
    }

    public List<GeneralJournalEntry> getGeneralJournalEntries() {
        return generalJournalEntries;
    }

    public Exercise getExercise() {
        return exercise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralJournal that = (GeneralJournal) o;
        return Objects.equals(generalJournalEntries, that.generalJournalEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generalJournalEntries);
    }

    @Override
    public String toString() {
        return "GeneralJournal{" +
                "generalJournalEntries=" + generalJournalEntries +
                '}';
    }
}
