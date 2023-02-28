package edu.pucmm.eict;

import java.time.LocalDate;

public class GeneralJournalEntry
{
    private Integer id;
    private LocalDate date;
    private String explanation;
    private GeneralJournal GeneralJournalRow;

    public GeneralJournalEntry(Integer id, LocalDate date, String explanation, GeneralJournal generalJourneyRow)
    {
        this.id = id;
        this.date = date;
        this.explanation = explanation;
        GeneralJournalRow = generalJourneyRow;
    }

    public Integer getId()
    {
        return id;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public String getExplanation()
    {
        return explanation;
    }

    public GeneralJournal getGeneralJournalRow()
    {
        return GeneralJournalRow;
    }
}
