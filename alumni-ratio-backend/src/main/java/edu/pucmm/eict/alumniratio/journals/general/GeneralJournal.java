package edu.pucmm.eict.alumniratio.journals.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.pucmm.eict.alumniratio.exercises.Exercise;
import edu.pucmm.eict.alumniratio.journals.general.analyzer.*;
import edu.pucmm.eict.alumniratio.transactions.Transaction;
import edu.pucmm.eict.alumniratio.transactions.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralJournal {

    @JsonIgnore
    private Exercise exercise;
    private List<GeneralJournalEntry> generalJournalEntries;

    public GeneralJournal() {
        this.generalJournalEntries = new ArrayList<>();
    }

    public GeneralJournal(Exercise exercise) {
        this.exercise = exercise;
        this.generalJournalEntries = new ArrayList<>();
    }

    public void addTransactionAsEntry(Transaction transaction) {
        var analyzerContext = new GeneralJournalAnalyzerContext();
        if (transaction.getType().equals(TransactionType.OWNER_INVESTMENT)) {
            analyzerContext.setAnalyzer(new OwnerInvestmentEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.OFFICE_SUPPLIES_PURCHASE)) {
            analyzerContext.setAnalyzer(new OfficeSuppliesPurchaseEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.OFFICE_EQUIPMENT_PURCHASE)) {
            analyzerContext.setAnalyzer(new OfficeEquipmentPurchaseEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.LAND_PURCHASE)) {
            analyzerContext.setAnalyzer(new LandPurchaseEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.OFFICE_SUPPLIES_PAYMENT)) {
            analyzerContext.setAnalyzer(new OfficeSuppliesPaymentEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.OFFICE_EQUIPMENT_PAYMENT)) {
            analyzerContext.setAnalyzer(new OfficeEquipmentPaymentEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.BANK_LOAN)) {
            analyzerContext.setAnalyzer(new BankLoanEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.BANK_LOAN_PAYMENT)) {
            analyzerContext.setAnalyzer(new BankLoanPaymentEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.SERVICE_REVENUES)) {
            analyzerContext.setAnalyzer(new ServiceRevenuesEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.PUBLIC_SERVICES_EXPENSES)) {
            analyzerContext.setAnalyzer(new PublicServicesExpensesEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.RENT_EXPENSES)) {
            analyzerContext.setAnalyzer(new RentExpensesEntryAnalyzer());
        }

        if (transaction.getType().equals(TransactionType.WAGES_EXPENSES)) {
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

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setGeneralJournalEntries(List<GeneralJournalEntry> generalJournalEntries) {
        this.generalJournalEntries = generalJournalEntries;
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
