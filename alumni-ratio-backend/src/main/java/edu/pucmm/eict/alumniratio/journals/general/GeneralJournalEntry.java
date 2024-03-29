package edu.pucmm.eict.alumniratio.journals.general;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralJournalEntry {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate date;
    private String explanation;
    private List<GeneralJournalRow> generalJournalRows;

    public GeneralJournalEntry() {
        this.generalJournalRows = new ArrayList<>();
    }

    public GeneralJournalEntry(LocalDate date, String explanation) {
        this.date = date;
        this.explanation = explanation;
        this.generalJournalRows = new ArrayList<>();
    }

    public void addRow(GeneralJournalRow row) {
        this.generalJournalRows.add(row);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<GeneralJournalRow> getGeneralJournalRows() {
        return generalJournalRows;
    }

    public void setGeneralJournalRows(List<GeneralJournalRow> generalJournalRows) {
        this.generalJournalRows = generalJournalRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralJournalEntry that = (GeneralJournalEntry) o;
        return Objects.equals(date, that.date) && Objects.equals(explanation, that.explanation) && Objects.equals(generalJournalRows, that.generalJournalRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, explanation, generalJournalRows);
    }

    @Override
    public String toString() {
        return "GeneralJournalEntry{" +
                "date=" + date +
                ", explanation='" + explanation + '\'' +
                ", generalJournalRows=" + generalJournalRows +
                '}';
    }
}
