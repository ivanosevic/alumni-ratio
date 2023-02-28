package edu.pucmm.eict;

import java.time.LocalDate;

public class GeneralJourneyEntry
{
    private Integer id;
    private LocalDate date;
    private String explanation;
    private GeneralJourney GeneralJourneyRow;

    public GeneralJourneyEntry(Integer id, LocalDate date, String explanation, GeneralJourney generalJourneyRow)
    {
        this.id = id;
        this.date = date;
        this.explanation = explanation;
        GeneralJourneyRow = generalJourneyRow;
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

    public GeneralJourney getGeneralJourneyRow()
    {
        return GeneralJourneyRow;
    }
}
