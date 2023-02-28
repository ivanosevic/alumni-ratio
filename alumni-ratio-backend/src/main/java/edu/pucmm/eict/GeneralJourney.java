package edu.pucmm.eict;

//Este es el diario general en el que se registran las primeras transacciones
public class GeneralJourney
{
    private Transaction GeneralJourneyEntry[];

    public GeneralJourney(Transaction[] generalJourneyEntry)
    {
        GeneralJourneyEntry = generalJourneyEntry;
    }

    public Transaction[] getGeneralJourneyEntry()
    {
        return GeneralJourneyEntry;
    }
}
