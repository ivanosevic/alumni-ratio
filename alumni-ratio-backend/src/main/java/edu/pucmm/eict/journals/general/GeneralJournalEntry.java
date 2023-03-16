package edu.pucmm.eict.journals.general;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralJournalEntry {
    private Integer id;
    private LocalDate date;
    private String explanation;
    private final List<GeneralJournalRow> generalJournalRows;

    public GeneralJournalEntry(Integer id, LocalDate date, String explanation) {
        this.id = id;
        this.date = date;
        this.explanation = explanation;
        this.generalJournalRows = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralJournalEntry that = (GeneralJournalEntry) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(explanation, that.explanation) && Objects.equals(generalJournalRows, that.generalJournalRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, explanation, generalJournalRows);
    }

    @Override
    public String toString() {
        return "GeneralJournalEntry{" +
                "id=" + id +
                ", date=" + date +
                ", explanation='" + explanation + '\'' +
                ", generalJournalRows=" + generalJournalRows +
                '}';
    }
}
